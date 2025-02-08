package LC_Questions.CollectionAll.BackTracking.Others.TupleWithSameProduct_1726;

import java.util.HashMap;
import java.util.Map;

public class HashMapSolution {
    public static void main(String[] args) {
        HashMapSolution solution = new HashMapSolution();
        int [] nums = {2,3,4,6};
        solution.tupleSameProduct(nums);
    }
    public int tupleSameProduct(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                hm.put(nums[i] * nums[j], hm.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        for (int val : hm.keySet()) {
            int feq = hm.get(val);
            int pair = ((feq - 1) * feq) / 2;
            ans += 8 * pair;
        }
        return ans;
    }
}
