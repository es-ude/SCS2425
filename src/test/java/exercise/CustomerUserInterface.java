package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerUserInterface {

    @Test
    void testConsole () {
        CustomerInterface C = new CustomerInterface();
        C.startBestellungsProzess();

    }
}
