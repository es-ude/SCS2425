package exercise;

public class Angebot{

    public Angebot (String[] pizzaArray){
        pizza = pizzaArray;
    }

    private String[] pizza;

    public String ausgeben() {
        StringBuilder ausgabe = new StringBuilder();
        for (int i = 0; i < pizza.length; i++) {
            ausgabe.append(String.format("[%d]: %s\n", i+1, pizza[i]));;
        }
        return ausgabe.toString();
    }

}
