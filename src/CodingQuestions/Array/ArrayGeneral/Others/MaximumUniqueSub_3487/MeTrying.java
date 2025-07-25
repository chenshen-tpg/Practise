package CodingQuestions.Array.ArrayGeneral.Others.MaximumUniqueSub_3487;

import java.util.HashSet;

public class MeTrying {
    public static void main(String[] args) {

    }
    public int maxSum(int[] nums) {
        int max = 0;
        int maxN = Integer.MIN_VALUE;
        HashSet<Integer> hs = new HashSet();
        for (int num : nums) {
            hs.add(num);
        }
        for (int h : hs) {
            if (h > 0) {
                max += h;
            } else if (h <= 0){
                maxN = Math.max(maxN, h);
            }
        }
        return max > 0 ? max : maxN;
    }
}
