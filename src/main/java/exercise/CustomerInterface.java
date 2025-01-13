package exercise;

import java.util.Scanner;

public class CustomerInterface {

    public static void Console (){

        System.out.println("Willkommen in der Pizzaria");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte wählen Sie ihre Pizza");
        System.out.println("0: Margaritha");
        System.out.println("1: Salami");
        System.out.println("2: Spinat");
        System.out.println("3: Thunfisch");

        int choice = scanner.nextInt();

        if (choice == 0) {
            System.out.println("You choose");
            System.out.println(0);
        }
        while(choice == 1) {
            System.out.println("möchten Sie noch eine Pizza");
            System.out.println("1: Ja");
            System.out.println("2: Nein, zur Kasse");
        }

        choice = scanner.nextInt();

        scanner.close();
    }
}
