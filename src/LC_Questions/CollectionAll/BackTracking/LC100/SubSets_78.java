package LC_Questions.CollectionAll.BackTracking.LC100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets_78 {
    private List<List<Integer>> output = new ArrayList();
    private int n, k;

    public static void main(String[] args) {
        System.out.println(subsets_HighestVote(new int[]{1,2,3}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                List<Integer> temp = new ArrayList(curr);
                temp.add(num);
                newSubsets.add(temp);
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) output.add(new ArrayList(curr));
        for (int i = first; i < n; ++i) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets_Recursive(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            ArrayList<Integer> currCombo = new ArrayList<Integer>();
            backtrack(0, currCombo, nums);
        }
        return output;
    }
    public List<List<Integer>> subsets_Lexicographic (int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }

    public static List<List<Integer>> subsets_HighestVote(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res , List<Integer> tempList, int [] nums, int start){
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            helper(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
