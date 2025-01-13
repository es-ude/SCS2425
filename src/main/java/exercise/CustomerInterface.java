package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CustomerInterface {
    public static Integer[] Bestellung;

    public static void startBestellungsProzess(){
        printAngebot();
        einlesenBestellung();
        weitereBestellung();
    }

    private static void weitereBestellung() {
        while (true){
            System.out.println("Möchte Sie weitere Pizzen? \n [1] Ja \n [2] Nein");
            Scanner myObj = new Scanner(System.in);
            Integer auswahl  = myObj.nextInt();
            if (auswahl == 2){
                printBestellung();
                break;
            }
            printAngebot();
        }
    }
    private static void printBestellung() {
        System.out.println(Arrays.toString(Bestellung));
    }
    private static void einlesenBestellung() {
        System.out.println("Welche Pizza möchten Sie?");
        Scanner scanner = new Scanner(System.in);
        Integer pizzaType = scanner.nextInt();
        System.out.println("Wie viele möchten Sie?");
        Integer pizzaAnzahl = scanner.nextInt();
        Bestellung = new Integer[]{pizzaType,pizzaAnzahl};
    }
    public static void getBestellung(){
        System.out.println(Bestellung.toString());
    }

    private static void printAngebot() {
        System.out.println("Willkommen in der Pizzaria");
        String[] pizza ={"Margarita", "Brokkoli", "Spinat"};
        //int[] preis ={10, 11, 12};
        for (int i = 0; i < pizza.length; i++) {
            System.out.print(i);
            System.out.print(": \t");
            System.out.println(pizza[i]);
            //System.out.println(preis[i]);
        }
    }
}
