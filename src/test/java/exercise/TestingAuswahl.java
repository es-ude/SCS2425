package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestingAuswahl {


    @Test
    void testAngebotAusgabe () {
        String[] pizza ={"A", "B", "S"};
        String expectedValue = "[1]: A\n[2]: B\n[3]: S\n";
        Auswahl a = new Auswahl(pizza);
        Assertions.assertEquals(expectedValue,a.ausgeben());
    }

}
