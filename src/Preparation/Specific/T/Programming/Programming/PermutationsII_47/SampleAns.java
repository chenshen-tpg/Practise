package Preparation.Specific.T.Programming.Programming.PermutationsII_47;

import java.util.ArrayList;
import java.util.List;

public class SampleAns {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, results, 0);
        return results;
    }

    private void permute(int[] nums, List<List<Integer>> results, int index) {
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            results.add(permutation);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            boolean duplicate = false;
            for (int j = index; j < i; j++) {
                if (nums[i] == nums[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                continue;
            }
            swap(nums, i, index);
            permute(nums, results, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
