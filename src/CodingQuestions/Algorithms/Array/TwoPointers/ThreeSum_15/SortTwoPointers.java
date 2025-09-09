package CodingQuestions.Algorithms.Array.TwoPointers.ThreeSum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTwoPointers {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum_helper(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++){
            if (i == 0 || nums[i - 1] != nums[i]){
                helper(nums,i,res);
            }
        }
        return res;
    }
    void helper(int [] nums, int i, List<List<Integer>> res){
        int l = i + 1, r = nums.length -1;
        while(l < r){
            int sum = nums[l] + nums[r] + nums[i];
            if(sum < 0) l++;
            else if (sum > 0) r--;
            else {
                res.add(Arrays.asList(nums[i],nums[l++],nums[r--]));
                while(l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
            }
        }
    }
}
