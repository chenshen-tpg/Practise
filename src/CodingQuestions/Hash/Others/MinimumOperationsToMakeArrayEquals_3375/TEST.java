package CodingQuestions.Hash.Others.MinimumOperationsToMakeArrayEquals_3375;

import java.util.HashSet;
import java.util.Set;

public class TEST {
    public static void main(String[] args) {

    }
    public int minOperations(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            if (num < k) return -1;
            else if (num > k) st.add(num);
        }
        return st.size();
    }
}
