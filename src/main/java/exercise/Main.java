package exercise;

public class Main {
    public static void main(String[] args) {
        String[] pizza ={"A", "B", "S"};
        Angebot myAngebot = new Angebot(pizza);
        CustomerInterface UI = new CustomerInterface(myAngebot);
        UI.startBestellungsProzess();

    }

}
