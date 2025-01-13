package exercise;

import PizzaOrder.Order;
import PizzaOrder.Printer;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {
    /*
        - null -> error
        - Order[date=LocalDateTime] -> "My Order\nDatum: "

     */

    @Test
    public void testPrint() {
        var date = LocalDateTime.of(2024, 5, 11, 14, 59, 42);
        Printer printer = new Printer();
        Order order = new Order();
        order.date = date;
        order.orderedPizzas = new ArrayList<>();
        order.orderedPizzas.add("Margarita 1.0€");
        order.orderedPizzas.add("Salami 2.0€");
        order.totalPrice = Float.valueOf(3.0f);
        order.street = "Teststraße 123, Duisburg";
        order.addressAdditions = "";
        order.firstname = "Max";
        order.lastname = "Müller";
        order.telephoneNumber = "01234/567890";
        var fmtString = printer.print(order);

        assertEquals("""
                Order
                Datum: 11.05.2024 14:59
                Order:
                Margarita 1.0€
                Salami 2.0€
                Total: 3.0€
                Address: Teststraße 123, Duisburg
                Tel.: 01234/567890
                Name: Max Müller""", fmtString);


    }

}