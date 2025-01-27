package LC_Questions.CollectionAll.BackTracking.Others;

import java.util.ArrayList;
import java.util.List;

public class Backtracking_example {



        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 4};
            System.out.println(subsets(nums));
        }

        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), nums, 0);
            return result;
        }

        private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
            if (tempList.size() == nums.length - 1) {
                result.add(new ArrayList<>(tempList));
            }
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
    }
}
