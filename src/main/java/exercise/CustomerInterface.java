package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CustomerInterface {
    private Auswahl AngebotsListePizza;
    private CustomerInterfaceState State = null;

    public CustomerInterface(Auswahl auswahl){
        AngebotsListePizza = auswahl;
        State = new WelcomeState(AngebotsListePizza);
    }
    public Integer[] Bestellung;

    public void startBestellungsProzess(){
        Scanner inputScanner = new Scanner(System.in);

        while(true) {
            String CustomerKeyBoardInput = inputScanner.nextLine();
            State = State.handleRequest(CustomerKeyBoardInput);
        }

//        printAngebot();
//        einlesenBestellung();
//        weitereBestellung();
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

    public void getBestellung(){
        System.out.println(Bestellung.toString()); //TODO: ausgliedern in Bestellungs Klasse
    }

    private void printAngebot() {
        System.out.println("Willkommen in der Pizzaria");
        AngebotsListePizza.ausgeben();
    }

}
