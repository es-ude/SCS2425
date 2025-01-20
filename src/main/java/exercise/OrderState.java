package exercise;

public class OrderState implements CustomerInterfaceState{
    private Auswahl AngebotsListePizza;

    public OrderState(Auswahl auswahl){
        AngebotsListePizza = auswahl;
    }
    @Override
    public CustomerInterfaceState handleRequest(String keyBoardInput) {
        System.out.println("OrderState");
        String howToNavigate = """
        \nHere is how you can interact with the app:
        - type "m" to see the menu
        - type "a" to add an item to your order
        - type "o" to see your order
        - type "f" to finish your order
        - type "q" to exit the app (without ordering!)\n
        """;
        System.out.println(howToNavigate);
        AngebotsListePizza.ausgeben();
        System.out.println();
        return new FinishOrder(AngebotsListePizza);
    }
}
