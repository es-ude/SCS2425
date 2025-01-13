package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CustomerInterface {
    private Auswahl AngebotsListePizza;

    public CustomerInterface(Auswahl auswahl){
        AngebotsListePizza = auswahl;
    }
    public Integer[] Bestellung;

    public void startBestellungsProzess(){
        printAngebot();
        einlesenBestellung();
        weitereBestellung();
    }

    private void weitereBestellung() {
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
    private void printBestellung() {
        System.out.println(Arrays.toString(Bestellung));
    }
    private void einlesenBestellung() {
        System.out.println("Welche Pizza möchten Sie?");
        Scanner scanner = new Scanner(System.in);
        Integer pizzaType = scanner.nextInt();
        System.out.println("Wie viele möchten Sie?");
        Integer pizzaAnzahl = scanner.nextInt();
        Bestellung = new Integer[]{pizzaType,pizzaAnzahl};
    }
    public void getBestellung(){
        System.out.println(Bestellung.toString()); //TODO: ausgliedern in Bestellungs Klasse
    }

    private void printAngebot() {
        System.out.println("Willkommen in der Pizzaria");
        AngebotsListePizza.ausgeben();
    }
}
