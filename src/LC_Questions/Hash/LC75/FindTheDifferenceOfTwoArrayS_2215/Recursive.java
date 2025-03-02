package LC_Questions.Hash.LC75.FindTheDifferenceOfTwoArrayS_2215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recursive {
    public static void main(String[] args) {

    }
    List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
        Set<Integer> onlyInNums1 = new HashSet<>();

        // Store nums2 elements in an unordered set.
        Set<Integer> existsInNums2 = new HashSet<> ();
        for (int num : nums2) {
            existsInNums2.add(num);
        }

        // Iterate over each element in the list nums1.
        for (int num : nums1) {
            if (!existsInNums2.contains(num)) {
                onlyInNums1.add(num);
            }
        }

        // Convert to vector.
        return new ArrayList<>(onlyInNums1);
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElementsOnlyInFirstList(nums1, nums2), getElementsOnlyInFirstList(nums2, nums1));
    }
}
