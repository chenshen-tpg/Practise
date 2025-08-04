package SystemDesignQuestions.LeeCodeStyleQ.FruitInToBasket_904;

import java.util.HashMap;
import java.util.Map;

public class TEST {
    public static void main(String[] args) {

    }
    public int totalFruit(int[] fruits) {
        int j = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 0; i < fruits.length; i++) {
            int curEnd = fruits[i];
            hm.put(curEnd, hm.getOrDefault(curEnd, 0) + 1);
            while (hm.size() > 2) {
                int curStart = fruits[j];
                hm.put(curStart, hm.get(curStart) - 1);
                if (hm.get(curStart) == 0) {
                    hm.remove(curStart);
                }
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
