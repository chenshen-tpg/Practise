package LC_Questions.Hash.Others.CountGoodMeals_1711;

import java.util.HashMap;
import java.util.Map;

public class IterationMHashMap {
    public static void main(String[] args) {
        int [] d = {1,3,5,7,9};
        solver(d);
    }

    public static int solver (int [] arr) {
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int num : arr) {
            int power = 1;
            for (int i = 0; i < 22; i++) {
                if (map.containsKey(power - num)) {
                    res += map.get(power - num);
                    res %= mod;
                }
                power *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) res;
    }

}
