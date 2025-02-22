package LC_Questions.CollectionAll.BackTracking.Others.CombinationSumI_39;

import java.util.ArrayList;
import java.util.List;

public class FindingAllSetII {

        public static void main(String[] args) {
            int[] nums = {1, 2, 3};
            List<List<Integer>> subsets = subsets(nums);
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
        }

        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int num : nums) {
                int size = res.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> newSubset = new ArrayList<>(res.get(i));
                    newSubset.add(num);
                    res.add(newSubset);
                }
            }
            return res;
        }
}
