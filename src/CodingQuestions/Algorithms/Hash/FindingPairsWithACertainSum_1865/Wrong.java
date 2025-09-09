package CodingQuestions.Algorithms.Hash.FindingPairsWithACertainSum_1865;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wrong {
    public static void main(String[] args) {

    }
    List<Integer> num1;
    List<Integer> num2;
    Map<Integer, Integer> num2Counts;
    public Wrong(int[] nums1, int[] nums2) {
        num1 = new ArrayList<>();
        num2 = new ArrayList<>();
        num2Counts = new HashMap<>();
        for (int num : nums1) num1.add(num);
        for (int num : nums2) {
            num2.add(num);
            num2Counts.put(num, num2Counts.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldValue = num2.get(index);
        num2Counts.put(oldValue, num2Counts.get(oldValue) - 1);
        if (num2Counts.get(oldValue) == 0) num2Counts.remove(oldValue);
        int newValue = oldValue + val;
        num2.set(index, newValue);
        num2Counts.put(newValue, num2Counts.getOrDefault(newValue, 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int n1 : num1) {
            int complement = tot - n1;
            if (num2Counts.containsKey(complement)) {
                res += num2Counts.get(complement);
            }
        }
        return res;
    }
}
