package exercise;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncoderJannik {

    public static int[] encode(int[] data) {
        List<Integer> encodedData = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < data.length; i++) {
            boolean didntReachEnd = i + 1 < data.length;
            boolean neighboursAreEqual = data[i] == data[i+ 1];
            if (didntReachEnd && neighboursAreEqual) {
                count++;
            } else {
                encodedData.add(data[i]);
                encodedData.add(count);
                count = 1;
            }
        }
        return listToArray(encodedData);
    }

    private static int[] listToArray(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).toArray();
    }

}
