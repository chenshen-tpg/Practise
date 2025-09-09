package Preparation.Specific.Altlassian.Programming.Programming.PermutationsII_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleAns3 {
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        SampleAns3 solution = new SampleAns3();
        solution.permuteUnique(nums);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> num = new ArrayList<>();
        for (int x : nums) {
            num.add(x);
        }
        helper(num, new ArrayList<>());
        return res;
    }

    public void helper(List<Integer> num, List<Integer> temp) {
        if (num.size() == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.size(); i++) {
            while (i + 1 < num.size() && num.get(i) == num.get(i + 1)) {
                i += 1;
            }
            temp.add(num.get(i));
            List<Integer> newNums = new ArrayList<>(num);
            newNums.remove(i);
            helper(newNums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
