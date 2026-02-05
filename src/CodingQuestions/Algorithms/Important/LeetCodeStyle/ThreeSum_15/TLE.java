package CodingQuestions.Algorithms.Important.LeetCodeStyle.ThreeSum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TLE {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> li = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length;j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> temp = new ArrayList();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if (!li.contains(temp)) {
                            li.add(temp);
                        }
                    }
                }
            }
        }
        return li;
    }
}
