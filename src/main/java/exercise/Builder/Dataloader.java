package exercise.Builder;

import java.util.Map;

public class Dataloader implements Pricelist {

    private Map<String, Float> lookupPizzaPrices = Map.of(
            "uuid1", 1f,
            "uuid2",  2f
    );

    @Override
    public Float getPrice(String uuid) {
        return lookupPizzaPrices.get(uuid);
    }
}
