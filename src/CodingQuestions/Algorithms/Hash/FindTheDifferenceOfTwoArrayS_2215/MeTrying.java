package CodingQuestions.Algorithms.Hash.FindTheDifferenceOfTwoArrayS_2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MeTrying {
    public static void main(String[] args) {

    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> num1 = new ArrayList();
        List<Integer> num2 = new ArrayList();
        Set<Integer> hs1 = new HashSet();
        Set<Integer> hs2 = new HashSet();
        for (int num : nums1) {
            hs1.add(num);
        }
        for (int num : nums2) {
            hs2.add(num);
        }
        for (int num : hs1) {
            if (!hs2.contains(num)) {
                num1.add(num);
            }
        }
        for (int num : hs2) {
            if (!hs1.contains(num)) {
                num2.add(num);
            }
        }
        res.add(num1);
        res.add(num2);
        return res;
    }
}
