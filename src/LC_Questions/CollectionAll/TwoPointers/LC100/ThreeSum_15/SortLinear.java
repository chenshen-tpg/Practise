package LC_Questions.CollectionAll.TwoPointers.LC100.ThreeSum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SortLinear {
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


}
