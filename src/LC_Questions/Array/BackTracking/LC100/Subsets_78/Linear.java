package LC_Questions.Array.BackTracking.LC100.Subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Linear {
    public static void main(String[] args) {

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
}
