package LC_Questions.LC_150.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation_46 {
    public static void main(String[] args) {
        Permutation_46 p = new Permutation_46();
        System.out.println(p.permute(new int[]{1,2,3}));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), result);
        return result;
    }

    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> result) {
        int len = nums.length;
        if (temp.size() == len) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            helper(nums, temp, result);
//            temp.remove(temp.size() - 1);
        }
    }

}
