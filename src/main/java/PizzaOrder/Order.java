package PizzaOrder;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    public Integer id;
    public LocalDateTime date;
    public List<String> orderedPizzas;
    public Float totalPrice;
    public String street;
    public String firstname;
    public String lastname;
    public String addressAdditions;
    public String telephoneNumber;
}
