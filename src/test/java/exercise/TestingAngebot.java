package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestingAngebot {


    @Test
    void testAngebotAusgabe () {
        String[] pizza ={"A", "B", "S"};
        String expectedValue = "[1]: A\n[2]: B\n[3]: S\n";
        Angebot a = new Angebot(pizza);
        Assertions.assertEquals(expectedValue,a.ausgeben());
    }

}
