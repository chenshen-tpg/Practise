package LC_Questions.Array.Hash.LC150.LongestConsecutiveSequence_128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
        System.out.println(longetConsecutive2(nums));
    }

    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int max = 0;
        for (int num: nums){
            if(!set.contains(num - 1)){
                int curNum = num;
                int curMax = 1;
                while(set.contains(curNum + 1)){
                    curNum++;
                    curMax++;
                }
                max = Math.max(max, curMax);
            }
        }
        return max;
    }
    private static int longetConsecutive2(int[] nums) {
        Arrays.sort(nums);
        int max = 1, cur = 1;
        for (int i = 0; i < nums.length - 1; i++) {
           if (nums[i] != nums[i+1]){
               if (nums[i] + 1 == nums[i+1]){
                   cur++;
               } else if (nums[i] != nums[i+1]){
                   max = Math.max(max, cur);
                   cur = 1;
               }
           }
        }
        return Math.max(max, cur);
    }
}
