package CodingQuestions.Algorithms.Array.Prefix.CountOfInterestingSubArrays_2845;

import java.util.List;

public class BruteForce {
    public static void main(String[] args) {

    }
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int cnt = 0;
            for (int j = i; j < nums.size(); j++) {
                if (nums.get(j) % modulo == k) cnt++;
                if (cnt % modulo == k) res++;
            }
        }
        return res;
    }
}
