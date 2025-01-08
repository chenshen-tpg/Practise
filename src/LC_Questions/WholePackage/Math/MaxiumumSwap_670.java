package LC_Questions.WholePackage.Math;

import java.util.PriorityQueue;

public class MaxiumumSwap_670 {

    public static void main(String[] args) {
        int num = 2736;
        method(num);
    }

    private static void method(int num) {
    }

    public static int method_Wrong (int num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->b - a);
        String str = Integer.toString(num);
        for (char c : str.toCharArray()) {
            pq.add(Character.getNumericValue(c));
        }
        int result = 0;
        while (!pq.isEmpty()) {
            result = result * 10 + pq.poll();
        }
        return result;
    }
}
