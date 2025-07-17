package CodingQuestions.Hash.LC75.FindTheDifferenceOfTwoArrayS_2215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Liner {
    public static void main(String[] args) {

    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> inNums1 = new HashSet<>();
        Set<Integer> inNums2 = new HashSet<>();
        for (int num : nums2) {
            inNums2.add(num);
        }
        for (int num : nums1) {
            if (!inNums2.contains(num)) {
                inNums1.add(num);
            }
        }
        Set<Integer> inNums3 = new HashSet<>();
        Set<Integer> inNums4 = new HashSet<>();
        for (int num : nums1) {
            inNums3.add(num);
        }
        for (int num : nums2) {
            if (!inNums3.contains(num)) {
                inNums4.add(num);
            }
        }
        List<Integer> lista = new ArrayList<>(inNums1);
        List<Integer> listb = new ArrayList<>(inNums4);

        return Arrays.asList(lista, listb);
    }
}
