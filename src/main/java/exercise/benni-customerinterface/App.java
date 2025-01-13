package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void greetUser() {
        String welcomeText = "Welcome to our online pizza delivery service Bella Italia!";
        System.out.println(welcomeText);
    }

    public static void showMenu() {
        HashMap <String, String> menu = new HashMap<>();
        menu.put("Pizza Margherita", "5€");
        menu.put("Pizza Salami", "6€");
        menu.put("Pizza Funghi", "6€");
        menu.put("Pizza Quattro Stagioni", "7€");
        menu.put("Pizza Prosciutto", "6.50€");
        menu.put("Pizza Diavola", "7.50€");
        
        for (Map.Entry<String, String> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void addItem(HashMap<String, String> userOrder) {
        // Dummy function
    }
    
    public static void showOrder(HashMap<String, String> userOrder) {
        // Dummy function
    }
    
    public static void finishOrder(HashMap<String, String> userOrder) {
        // Dummy function
    }


    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        HashMap <String, String> userOrder = new HashMap<>();;
        
        // VARIABLES
        String howToNavigate = """
        \nHere is how you can interact with the app:
        - type "m" to see the menu
        - type "a" to add an item to your order
        - type "o" to see your order
        - type "f" to finish your order
        - type "q" to exit the app (without ordering!)\n
        """;
        HashMap<String, String> commands = new HashMap<>();
        commands.put("w", "welcome");
        commands.put("m", "menu");
        commands.put("a", "add");
        commands.put("o", "order");
        commands.put("f", "finish");
        commands.put("q", "quit");
            
        String input = "w";
        String command = commands.get(input);
        boolean shouldBreak = false;

        while (!shouldBreak) {
            switch (command) {
                case "welcome":
                    greetUser();
                    break;
            
                case "menu":
                    showMenu();
                    break;
            
            
                case "add":
                    addItem(userOrder);
                    break;
            
            
                case "order":
                    showOrder(userOrder);
                    break;
            
            
                case "finish":
                    finishOrder(userOrder);
                    break;

                case "quit":
                    shouldBreak = true;
                    break;
            
                default:
                    break;
            }
            
            if (!shouldBreak) {
                System.out.println(howToNavigate);
                input = inputScanner.nextLine();
                command = commands.get(input);
                input.toLowerCase();
            }
        }
    }

}
