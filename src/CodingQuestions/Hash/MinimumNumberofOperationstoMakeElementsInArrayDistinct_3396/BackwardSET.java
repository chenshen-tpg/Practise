package CodingQuestions.Hash.MinimumNumberofOperationstoMakeElementsInArrayDistinct_3396;

import java.util.HashSet;
import java.util.Set;

public class BackwardSET {
    public static void main(String[] args) {

    }
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                return i / 3 + 1;
            }
            set.add(nums[i]);
        }
        return 0;
    }
}
