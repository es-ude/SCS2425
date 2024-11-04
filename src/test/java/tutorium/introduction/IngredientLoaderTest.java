package tutorium.introduction;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientLoaderTest {

    public class FileReaderDummy implements FileReader{
        private String text;

        public FileReaderDummy(String text) {
            this.text = text;
        }
        public String read() {
            return text;
        }
    }
    @Test
    public void loadThreeDoughs()  {
        var reader = new FileReaderDummy("""
dough: wheat, whole grain, gluten free
""");
        var il = new IngredientLoader(reader);
        var ingredients = il.load();
        var exptected_options = List.of("wheat", "whole grain", "gluten free");
        var options_for_dough = ingredients.get("dough");
        assertEquals(exptected_options, options_for_dough);
    }

    @Test
    public void loadGlutenFreeDough() {
        var reader = new FileReaderDummy("""
dough: gluten free
""");
        var il = new IngredientLoader(reader);
        var ingredients = il.load();
        var options_for_dough = ingredients.get("dough");
        var expected_options = List.of("gluten free");
        assertEquals(expected_options, options_for_dough);
    }
}
