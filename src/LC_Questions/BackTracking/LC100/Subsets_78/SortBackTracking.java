package LC_Questions.BackTracking.LC100.Subsets_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortBackTracking {
    List<List<Integer>> res;
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets_HighestVote(int[] nums) {
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>());
        return res;
    }

    private void helper(int start, int [] nums, List<Integer> tempList){
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            helper(i + 1, nums, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
