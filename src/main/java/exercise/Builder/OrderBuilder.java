package exercise.Builder;

import java.time.LocalDateTime;
import java.util.*;

public class OrderBuilder {

    private final Pricelist pricelist;

    private List<String> orderedPizzaList = new ArrayList<>();
    private String street = "";
    private String firstName = "";
    private String lastName = "";
    private String phonenumber = "";
    private String addressAddition = "";

    public OrderBuilder(Pricelist pricelist) {
        this.pricelist = pricelist;
    };

    public OrderBuilder addOrderedPizzaList(List<String> orderedPizzaList) {
        this.orderedPizzaList = orderedPizzaList;
        return this;
    }

    public OrderBuilder addStreet(String street) {
        this.street = street;
        return this;
    }

    public OrderBuilder addCustomerFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public OrderBuilder addCustomerLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public OrderBuilder addCustomerPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public OrderBuilder addAddressAdditions(String addressAddition) {
        this.addressAddition = addressAddition;
        return this;
    }

    private Float calculateTotalPrice() {
        return orderedPizzaList.stream()
                .map(pricelist::getPrice)
                .reduce(0f, Float::sum);
    };

    public Order createOrder() {
        Float totalPrice = calculateTotalPrice();
        return new Order(
                UUID.randomUUID(),
                LocalDateTime.now(),
                this.orderedPizzaList,
                totalPrice,
                this.street,
                this.firstName,
                this.lastName,
                this.phonenumber,
               this.addressAddition
                );
    }
}
