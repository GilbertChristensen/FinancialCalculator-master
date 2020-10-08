package models;

public class FinancialModels {
    

    /**
     * Funktion til at beregne rentefod
     * @param futureCapital angiver Kn = slutværdien
     * @param presentCapital angiver K0 = startværdien
     * @param periods angiver n = antallet af terminer
     * @return r = den beregnede rentefod over den givne periode og kapitalforøgelse/formindskelse
     */
    public double calculateInterest(double futureCapital, double presentCapital, double periods) {
        return -1+Math.pow((futureCapital/presentCapital),(1/periods));
    }   
    
    /**
     * Funktion til at beregne startkapital
     * @param futureCapital angiver Kn = slutværdien
     * @param interest angiver r = renten
     * @param periods angiver n = antallet af terminer/perioder
     * @return k0 = startkapitalen på baggrund af de ovenstående parametre
     */
    
    public double calculatePresentCapital(double futureCapital, double interest, double periods) { 
        return futureCapital/(Math.pow((1+interest),periods));
    }
    
     /**
     * Funktion til at beregne fremtidig værdi
     * @param presentCapital angiver K0 = startværdien
     * @param interest angiver r = rentefoden
     * @param periods angiver n = antallet af terminer
     * @return Kn = slutværdien efter en given mængde terminer med en bestmt rentefod og kapital
     */
    public double calculateFutureCapital(double presentCapital, double interest, double periods) {
        return presentCapital*(Math.pow((1+interest),periods));
    }
    
    /**
     * Funktion til at beregne antallet af terminer
     * @param futureCapital angiver Kn = slutværdien
     * @param presentCapital k0 = startværdien
     * @param interest r = renten
     * @return n = antallet af terminer på baggrund af overstående parametre
     */
    
    public double calculatePeriods(double futureCapital, double presentCapital, double interest) {
        return Math.log(futureCapital/presentCapital)/Math.log(1+interest);
    }
    
    /**
     * Funktion til at beregne fremtidsværdien af en annuitet (annuitetsopsparing)
     * @param ydelse angiver y = ydelsen
     * @param periods n = antallet af terminer
     * @param interest r = renten
     * @return A_n = Fremtidsværdien af en annuitet på baggrund af overstående parametre
     */
    
    public double calculateAnnuitet(double ydelse, double periods, double interest) {
        return ydelse*((Math.pow((1+interest),periods)-1)/interest);
    }
    
    /**
     * Funktion til at beregne restgælden for et lån
     * @param hovedstol A0 = hovedstolen for lånet
     * @param ydelse y = ydelsen der skal betales hver termin
     * @param interest r = renten for lånet
     * @param periods t = antallet af terminer
     * @return Rt = restgælden for lånet beregnet på baggrund af overstående parametre
     */
    
    public double calculateOutstandingDebt(double hovedstol, double ydelse, double interest, double periods) {
        return hovedstol*(Math.pow((1+interest),periods)) - (ydelse*((Math.pow((1+interest),periods)-1)/interest));
    }
}