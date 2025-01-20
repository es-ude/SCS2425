package exercise.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record Order(UUID id,
                    LocalDateTime date,
                    List<String> orderedPizzas,
                    Float totalPrice,
                    String street,
                    String firstName,
                    String lastName,
                    String phonenumber,
                    String addressAdditions
                    ) {
}
