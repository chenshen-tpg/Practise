package LC_Questions.ClassicQ.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i + 1; j < nums.length; j++) {
                int key = -nums[i] - nums[j];
                if (hm.containsKey(key) && hm.get(key) > j) {
                    li.add(Arrays.asList(nums[i], nums[j], key));
                    j = hm.get(nums[j]);
                }
            }
            i = hm.get(nums[i]);
        }
        return li;
    }
    public List<List<Integer>> threeSumRewrite (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int key = - nums[i] - nums[j];
                if (hm.containsKey(key) && hm.get(key) > j) {
                    res.add(Arrays.asList(nums[i], nums[j], key));
                    j = hm.get(nums[j]);
                }
            }
            i = hm.get(nums[i]);
        }
        return res;
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
