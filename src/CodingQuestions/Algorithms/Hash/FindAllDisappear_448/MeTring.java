package CodingQuestions.Algorithms.Hash.FindAllDisappear_448;

import java.util.ArrayList;
import java.util.List;

public class MeTring {
    public static void main(String[] args) {

    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        int [] memo = new int [nums.length + 1];
        for (int num : nums) memo[num] ++;
        for (int i = 1; i < memo.length; i++) {
            if (memo[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
