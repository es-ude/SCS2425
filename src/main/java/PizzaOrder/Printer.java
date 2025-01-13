package PizzaOrder;

import javax.print.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Printer {
//    Integer id;
//    LocalDateTime date;
//    List<String> orderedPizzas;
//    Float totalPrice;
//    String street;
//    String firstname;
//    String lastname;
//    String addressAdditions;
    public String print(Order order) {
        String outputStr = "Order\n";
        outputStr += printDatum(order.date) + "\n";
        outputStr += printOrderedPizza(order.orderedPizzas) + "\n";
        outputStr += "Total: " + order.totalPrice + "€\n";
        outputStr += "Address: " + order.street + order.addressAdditions + "\n";
        outputStr += "Tel.: " + order.telephoneNumber + "\n";
        outputStr += "Name: " + order.firstname + " " + order.lastname;
        // Address, tel, Name
        return outputStr;
    }

    private String printDatum(LocalDateTime datum) {
        // print datum
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return "Datum: " + datum.format(formatter);
    }

    private String printOrderedPizza(List<String> orderedPizzas) {
        return "Order:\n" + String.join("\n", orderedPizzas);
    }

    public void printToPrinter(String txt) {
        try {
            InputStream inputStream = new ByteArrayInputStream(txt.getBytes());

            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();

            if(printService != null) {
                DocPrintJob printJob = printService.createPrintJob();

                Doc doc = new SimpleDoc(inputStream, flavor, null);

                printJob.print(doc, null);

                System.out.println("Printed successfully");
            } else {
                System.out.println("No print service found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
