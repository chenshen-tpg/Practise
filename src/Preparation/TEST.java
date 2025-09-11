package Preparation;

import java.util.Arrays;
import java.util.List;

public class TEST {
    public static void main(String[] args) {


        Double[] test = new Double[] {8.0, 10.7, 17.1, 11.2, 13.5, 9.9, 14.9, 9.4, 9.4, 3.1, 12.7};
        countPeaks(Arrays.asList(test));
    }
    public static int countPeaks(List<Double> values) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        int peak = 0;
        for (int i = 1; i < values.size() - 1; i++) {
            if (values.get(i) >= values.get(i - 1) + 5 && values.get(i) >= values.get(i + 1) + 5) {
                peak++;
            } else if ( values.get(i) + 5 <= values.get(i - 1) && values.get(i) <= values.get(i + 1) + 5) {
                peak++;
            }
        }
        return peak;
    }
}
