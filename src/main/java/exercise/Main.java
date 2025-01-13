package exercise;

public class Main {
    public static void main(String[] args) {
        String[] pizza ={"A", "B", "S"};
        Auswahl myAuswahl = new Auswahl(pizza);
        CustomerInterface UI = new CustomerInterface(myAuswahl);
        UI.startBestellungsProzess();
    }
}
