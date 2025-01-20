package exercise;

import java.util.HashMap;
import java.util.Scanner;


public class WelcomeState implements CustomerInterfaceState {
    private Auswahl AngebotsListePizza;

    public WelcomeState(Auswahl auswahl){
        AngebotsListePizza = auswahl;
    }
    @Override
    public CustomerInterfaceState handleRequest(String keyBoardInput) {
        String howToNavigate = """
        \nHere is how you can interact with the app:
        - type "m" to see the menu
        - type "a" to add an item to your order
        - type "o" to see your order
        - type "f" to finish your order
        - type "q" to exit the app (without ordering!)\n
        """;
        String welcomeText = "Welcome to our online pizza delivery service Bella Italia!";
        System.out.println(howToNavigate);
        System.out.println(welcomeText);

        switch(keyBoardInput){
            case("m"):
                printAngebot();
                return this;
            case("a"):
                return new OrderState(AngebotsListePizza);

        }


        return new OrderState(AngebotsListePizza);
    }
    private void printAngebot() {
        System.out.println("Willkommen in der Pizzaria");
        AngebotsListePizza.ausgeben();
    }
}
