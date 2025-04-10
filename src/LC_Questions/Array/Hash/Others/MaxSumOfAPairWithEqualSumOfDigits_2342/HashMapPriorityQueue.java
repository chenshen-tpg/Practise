package LC_Questions.Array.Hash.Others.MaxSumOfAPairWithEqualSumOfDigits_2342;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HashMapPriorityQueue {
    public static void main(String[] args) {
        int [] nums = {279,169,463,252,94,455,423,315,288,64,494,337,409,283,283,477,248,8,89,166,188,186,128};



        System.out.println(maximumSum(nums));
    }
    public static int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        int max = -1;
        for (int num : nums) {
            int digitSum = 0;
            int temp = num;
            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
//            if (!hm.containsKey(digitSum)) {
//                hm.put(digitSum, new PriorityQueue<>());
//            }
//            hm.get(digitSum).offer(num);
            hm.computeIfAbsent(digitSum, k -> new PriorityQueue<>()).offer(num);
            if (hm.get(digitSum).size() > 1) {
                int num1 = hm.get(digitSum).poll();
                int num2 = hm.get(digitSum).poll();
                max = Math.max(max, num1 + num2);
                hm.get(digitSum).offer(num2);
            }
        }
        return max;
    }
}
