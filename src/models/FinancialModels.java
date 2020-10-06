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
     * @return k0 = startkapitalen på baggrund af de ovenstående parametere
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
     * @return n = antallet af terminer på baggrund af overstående parametere
     */
    
    public double calculatePeriods(double futureCapital, double presentCapital, double interest) {
        return Math.log(futureCapital/presentCapital)/Math.log(1+interest);
    }
}