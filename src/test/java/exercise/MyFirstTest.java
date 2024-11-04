package exercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirstTest {

    @Test
    void first_test() {
        var c = new Calculator();
        assertEquals(3, c.add(1, 2));
    }
}
