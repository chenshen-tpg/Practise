package LC_Questions.WholePackage.BackTracking.Others;

import java.util.ArrayList;
import java.util.List;

public class ExampleOfFindingAllset {

        public static void main(String[] args) {
            int[] nums = {1, 2, 3};
            List<List<Integer>> subsets = subsets(nums);
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
        }

        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(res, new ArrayList<>(), nums, 0);
            return res;
        }

        private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {

            res.add(new ArrayList<>(temp));
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(res, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

}
