package LC_Questions.Array.SlidingWindow.Others.FruitInBaskets_904;

import java.util.HashMap;

public class SlidingWindows {
    public static void main(String[] args) {
        helper(new int [] {1, 2, 3, 2, 2});
    }

    private static int helper(int[] ints) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int j = 0,  i;
        for (i = 0; i < ints.length; i++) {
            hm.put(ints[i], hm.getOrDefault(ints[i],0) + 1);
            if (hm.size() > 2) {
                hm.put(ints[j], hm.get(ints[j]) - 1);
                if (hm.get(ints[j]) == 0) {
                    hm.remove(ints[j]);
                }
                j++;
            }
        }
        return j - i;
    }

}
