package LC_Questions.Hash.Others.MinimumNumberofOperationstoMakeElementsInArrayDistinct_3396;

import java.util.HashSet;

public class Inward {
    public static void main(String[] args) {

    }
    class Solution {

        public int minimumOperations(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i += 3, ans++) {
                if (checkUnique(nums, i)) {
                    return ans;
                }
            }
            return ans;
        }

        private boolean checkUnique(int[] nums, int start) {
            HashSet<Integer> cnt = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (cnt.contains(nums[i])) {
                    return false;
                }
                cnt.add(nums[i]);
            }
            return true;
        }
    }
}
