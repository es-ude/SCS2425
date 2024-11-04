package tutorium.introduction;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IngredientLoader {
    private FileReader reader;

    public IngredientLoader(FileReader reader) {
        this.reader = reader;
    }

    public Map<String, List<String>> load() {
        var read_string = reader.read();
        var string_array = read_string.split(":");
        var category = string_array[0];
        var names = string_array[1].split(",");
        for (int i = 0; i < names.length; i++){
            names[i] = names[i].strip();
        }
        return Map.of(category, List.of(names));
    }
}
