package CodingQuestions.Algorithms.Array.BitManipulation.BitwiseXorOfAllPairs_2425;

import java.util.HashMap;
import java.util.Map;

public class BitwiseXORofAllPairings_2425 {
    public static void main(String[] args) {
        int [] nums1 = {2, 1, 3};
        int [] nums2 = {10, 2, 5, 0};
        System.out.println(ModelSolution(nums1, nums2));
    }
    public static int xor (int [] nums1, int [] nums2) {
       int [] res = new int[nums1.length * nums2.length];
       int i = 0;
        int index = 0;
        for (Integer num1: nums1) {
            for (Integer num2: nums2) {
                res[i] = num1 ^ num2;
            }
        }
        return res.length;
    }

    public static int ModelSolution (int [] nums1, int [] nums2) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        //appear length of time, we could add the length here.
        for (int num : nums1) freq.put(num, freq.getOrDefault(num, 0) + nums2.length);
        for (int num : nums2) freq.put(num, freq.getOrDefault(num, 0) + nums1.length);
        for (int num : freq.keySet()) {
            if (freq.get(num) % 2 == 1) ans ^= num;
        }
        return ans;
    }

}
