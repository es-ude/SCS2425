package exercise;

import exercise.Builder.Dataloader;
import exercise.Builder.Order;
import exercise.Builder.OrderBuilder;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderBuilderTest {
    /*
    Test list

    validate price calculation
    validate address
    validate person
    validate additions
     */

   @Test
   public void testCalculationOfTotalPrice() {
       OrderBuilder builder = new OrderBuilder(
               new Dataloader());
       Float test = 3f;
       builder.addOrderedPizzaList(Arrays.asList("uuid2", "uuid1"));
       Order actual = builder.createOrder();
       assertEquals(test, actual.totalPrice());
   }

   @Test void testPipingOfAddressInformation() {
       String test = "Bismarck Str. 31";
       OrderBuilder builder = new OrderBuilder(new Dataloader());
       builder.addStreet(test);
       Order actual = builder.createOrder();
       assertEquals(test, actual.street());
   }

    @Test void testPipingOfFirstName() {
        String test = "John";
       OrderBuilder builder = new OrderBuilder(new Dataloader());
       builder.addCustomerFirstName(test);
       Order actual = builder.createOrder();
        assertEquals(test, actual.firstName());
    }

    @Test void testPipingOfLastName() {
        String test = "Smith";
        OrderBuilder builder = new OrderBuilder(new Dataloader());
        builder.addCustomerLastName(test);
        Order actual = builder.createOrder();
        assertEquals(test, actual.lastName());
    }

    @Test void testPipingOfPhonenumber() {
        String test = "+4958785748925043205489257";
        OrderBuilder builder = new OrderBuilder(new Dataloader());
        builder.addCustomerPhonenumber(test);
        Order actual = builder.createOrder();
        assertEquals(test, actual.phonenumber());
    }

    @Test void testPipingOfAddressAdditions() {
        String test = "Such Wow! Much Additions";
        OrderBuilder builder = new OrderBuilder(new Dataloader());
        builder.addAddressAdditions(test);
        Order actual = builder.createOrder();
        assertEquals(test, actual.addressAdditions());
    }
}