package io;

import java.util.Scanner;
import models.FinancialModels;

/**
 * Hele inputOutputTool classen er til for at kommunikere med brugeren.
 */

public class InputOutputTool {
    
    FinancialModels model = new FinancialModels();
    Scanner sc;

    public void welcome() {
        System.out.println(this.welcomeString);
        this.menu();
    }
    
    /**
     * Funktionen får brugerens input og vælger ud fra dette hvilken funktion fra FinancialModels.java, der skal bruges.
     */
    public void menu() {
        System.out.println(this.menuString);
        sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equals("1")) {
            this.futureCapitalChosen();
        }
        else if(input.equals("2")) {
            this.interestChosen();
        }
        else if(input.equals("3")) {
            this.numerOfPeriodsChosen();
        }
        else if(input.equals("4")) {
            this.presentCapital();
        }
        else if(input.equals("5")) {
            this.annuitetChosen();
        }
        else if(input.equals("6")) {
             this.outstandingDebt();
        } 
        else if(input.equals("7")) {
            System.out.println("Programmet afsluttes");
        }
        else {
            System.out.println("error 404: ukendt forespøgsel, prøv venligst igen");
            menu();
        }
    }
    
    /**
     * Funktionen anmoeder brugeren om input, og bruger de værdier til at udregne slutkapitalen.
     */
    public void futureCapitalChosen() {
        try {
            System.out.println("Venligst indtast din nuværende kapital: ");      
            double capital = (double) Double.parseDouble(sc.nextLine());
            System.out.println("Venligst indtast din rente i antal procent: ");
            double interest = (double) Double.parseDouble(sc.nextLine())/100;
            System.out.println("Venligst indtast den ønskede tidsperiode i antal terminer: ");
            double periods = (double) Double.parseDouble(sc.nextLine());
            double result = model.calculateFutureCapital(capital, interest, periods);
            System.out.println("Om "+periods+" terminer med følgende kapital: "+capital+" og renten: "+interest+" vil du nå følgende sum "+result+"\n");
            menu(); }
        catch(NumberFormatException e) {
            System.out.println("Ugyldigt input\n");
            this.futureCapitalChosen();
        }
    }
    
    /**
     * Funktionen anmoeder brugeren om input, og bruger de værdier til at udregne antal terminer.
     */
    public void numerOfPeriodsChosen() {
        try {
            System.out.println("Venligst indtast din nuværende kapital: ");
            double presentCapital = (double) Double.parseDouble(sc.nextLine());
            System.out.println("Venligst indtast din rente i antal procent: ");
            double interest = (double) Double.parseDouble(sc.nextLine())/100;
            System.out.println("Venligst indtast din ønskede slutkapital");
            double futureCapital = (double) Double.parseDouble(sc.nextLine());
            double result = model.calculatePeriods(futureCapital, presentCapital, interest);
            System.out.println("Med startkapital: "+presentCapital+", renten "+interest+", og ønskede slutkapital på "+futureCapital+", vil du skulle vente "+result+" terminer\n");
            menu(); }
        catch(NumberFormatException e) {
            System.out.println("Ugyldigt input\n");
            this.numerOfPeriodsChosen();
        }
    }
    
    /**
     * Funktionen anmoeder brugeren om input, og bruger de værdier til at udregne renten.
     */
    public void interestChosen() {
        try {
            System.out.println("Venligst indtast din nuværende kapital: ");
            double presentCapital = (double) Double.parseDouble(sc.nextLine());
            System.out.println("Venligst indtast antallet af terminer ");
            double periods = (double) Double.parseDouble(sc.nextLine());
            System.out.println("Venligst indtast din ønskede slutkapital");
            double futureCapital = (double) Double.parseDouble(sc.nextLine());
            double result = model.calculateInterest(futureCapital, presentCapital, periods);
            System.out.println("Med startkapital: "+presentCapital+", slutkapital: "+futureCapital+", og antallet af terminer: "+periods+", har du modtaget renten: "+result+"\n");
            menu(); }
        catch(NumberFormatException e) {
            System.out.println("Ugyldigt input\n");
            this.interestChosen();
        }
    }
    
    /**
     * Funktionen anmoeder brugeren om input, og bruger de værdier til at udregne startkapitalen.
     */
    public void presentCapital() {
        try {
            System.out.println("Venligst indtast din slutkapital: ");
            double futureCapital = (double) Double.parseDouble(sc.nextLine());
            System.out.println("Venligst indtast din rente i procent: ");
            double interest = (double) Double.parseDouble(sc.nextLine())/100;
            System.out.println("Venligst indtast antallet af terminer: ");
            double periods = (double) Double.parseDouble(sc.nextLine());
            double result = model.calculatePresentCapital(futureCapital, interest, periods);
            System.out.println("Med slutkapitalen: "+futureCapital+", renten: "+interest+" og antallet af terminer: "+periods+", har du startkapitalen: "+result+"\n");
            menu(); }
        catch(NumberFormatException e) {
            System.out.println("Ugyldigt input\n");
            this.presentCapital();
        }
    }
    
    /**
     * Funktionen anmoeder brugeren om input, og bruger de værdier til at udregne fremtidværdien for en annuitetsopsparing.
     */
    public void annuitetChosen() {
        try {
            System.out.println("Venligst indtast ydelsen som du vil betale hver termin: ");
            double ydelse = (double) Double.parseDouble(sc.nextLine());
            System.out.println("Venligst indtast antallet af terminer: ");
            double periods = (double) Double.parseDouble(sc.nextLine());
            System.out.println("Venligst indtast din rente i antal procent: ");
            double interest = (double) Double.parseDouble(sc.nextLine())/100;
            double result = model.calculateAnnuitet(ydelse, periods, interest);
            System.out.println("Med ydelsen: "+ydelse+", renten: "+interest+" og antallet af terminer: "+periods+", har du en annuitetsopsparing på: "+result+"\n");           
            menu(); }
        catch(NumberFormatException e) {
            System.out.println("Ugyldigt input\n");
            this.annuitetChosen();
        }
    }
    
    /**
     * Funktionen anmoeder brugeren om input, og bruger de værdier til at udregne restgæld.
     */
    public void outstandingDebt() {
        try {
            System.out.println("Venligst indtast hovedstolen på dit lån: ");
            double hovedstol = (double) Double.parseDouble(sc.nextLine());
            System.out.println("Venligst indtast ydelsen du vil indbetale hver termin: ");
            double ydelse = (double) Double.parseDouble(sc.nextLine());
            System.out.println("Venligst indtast din rente i procent: ");
            double interest = (double) Double.parseDouble(sc.nextLine())/100;
            System.out.println("Venligst indtast antallet af terminer du vil betale dit af på dit lån: ");
            double periods = (double) Double.parseDouble(sc.nextLine());
            double result = model.calculateOutstandingDebt(hovedstol, ydelse, interest, periods);
            System.out.println("Med hovedstolen: "+hovedstol+", ydelsen: "+ydelse+", renten: "+interest+" og antallet af terminer: "+periods+" vil du få en restgæld på: "+result+"\n");
            menu(); }
        catch(NumberFormatException e) {
            System.out.println("Ugyldigt input\n");
            this.outstandingDebt();
        }
    }
    
    String welcomeString = "\n\n\n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + " _______ _______ _______ _______ _______ _______ _______ _______ _______ \n"
            + "(_______|_______|_______|_______|_______|_______|_______|_______|_______)\n"
            + "                                                                         \n"
            + " _     _       _  _                                           _ _        \n"
            + "(_)   (_)     | || |                                      _  (_) |       \n"
            + " _     _ _____| || |  _ ___  ____  ____  _____ ____     _| |_ _| |       \n"
            + "| |   | | ___ | || |_/ ) _ \\|    \\|    \\| ___ |  _ \\   (_   _) | |       \n"
            + " \\ \\ / /| ____| ||  _ ( |_| | | | | | | | ____| | | |    | |_| | |       \n"
            + "  \\___/ |_____)\\_)_| \\_)___/|_|_|_|_|_|_|_____)_| |_|     \\__)_|\\_)      \n"
            + "                                                                         \n"
            + "     _                   ___ _                        _       _ _        \n"
            + "    | |                 / __|_)                      (_)     | | |       \n"
            + "  __| |_____ ____     _| |__ _ ____  _____ ____   ___ _ _____| | | _____ \n"
            + " / _  | ___ |  _ \\   (_   __) |  _ \\(____ |  _ \\ /___) | ___ | | || ___ |\n"
            + "( (_| | ____| | | |    | |  | | | | / ___ | | | |___ | | ____| | || ____|\n"
            + " \\____|_____)_| |_|    |_|  |_|_| |_\\_____|_| |_(___/|_|_____)\\_)_)_____)\n"
            + "                                                                         \n"
            + " _                                                                       \n"
            + "| |                                                                      \n"
            + "| | ___  ____  ____  _____  ____ _____  ____ ____  _____  ____           \n"
            + "| |/ _ \\|    \\|    \\| ___ |/ ___) ___ |/ _  |  _ \\| ___ |/ ___)          \n"
            + "| | |_| | | | | | | | ____| |   | ____( (_| | | | | ____| |              \n"
            + " \\_)___/|_|_|_|_|_|_|_____)_|   |_____)\\___ |_| |_|_____)_|              \n"
            + "                                      (_____|                            \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + " _______ _______ _______ _______ _______ _______ _______ _______ _______ \n"
            + "(_______|_______|_______|_______|_______|_______|_______|_______|_______)\n"
            + "                                                                         ";


    String menuString = "\n\n"
            + "\nVælg 1 for at beregne fremtidsværdi af nuværende kapital"
            + "\nVælg 2 for at beregne rente mellem to perioder"
            + "\nVælg 3 for at beregne antallet af terminer for at opnå en bestemt kapital"
            + "\nVælg 4 for at beregne din startkapital"
            + "\nVælg 5 for at beregne din annuitetsopsparing"
            + "\nVælg 6 for at beregne din restgæld for et lån"
            + "\nVælg 7 for at afslutte programmet";
    
}