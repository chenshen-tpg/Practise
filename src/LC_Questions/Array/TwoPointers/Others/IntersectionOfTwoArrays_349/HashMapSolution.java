package LC_Questions.Array.TwoPointers.Others.IntersectionOfTwoArrays_349;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSolution {
    public static void main(String[] args) {

    }
    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> seen = new HashMap();
        List<Integer> result = new ArrayList<>();

        for (int x : nums1) seen.put(x, 1);



        for (int x : nums2) {
            if (seen.containsKey(x) && seen.get(x) == 1) {
                result.add(x);
                seen.put(x, 0);
            }
        }

        // Convert to int array and result the result
        return result.stream().mapToInt(i->i).toArray();

    }
}
