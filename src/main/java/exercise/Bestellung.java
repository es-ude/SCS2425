package exercise;
import java.util.HashMap;

public class Bestellung {


    public Bestellung (Integer[] bestarray[]) {order =bestarray;}

    public void additem(){
        HashMap<Integer, Integer> completeOrder = new HashMap<Integer, Integer>();
        completeOrder.put(order[0],order[1]);
    }
}
