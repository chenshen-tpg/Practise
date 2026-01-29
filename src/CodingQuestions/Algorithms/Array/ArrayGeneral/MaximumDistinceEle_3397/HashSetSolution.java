package CodingQuestions.Algorithms.Array.ArrayGeneral.MaximumDistinceEle_3397;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetSolution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4};
        int k = 2;
        HashSetSolution obj = new HashSetSolution();
        System.out.println(obj.maxDistinctElementsNEXT(nums, k));
    }
    public int maxDistinctElementsNEXT(int[] arr, int diff) {
        int prev = Integer.MIN_VALUE;
        Set<Integer> ans = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int selectNum = Math.max(prev + 1, arr[i] - diff);
            if (selectNum <= arr[i] + diff) {
                prev = selectNum;
                ans.add(selectNum);
            }
        }
        return ans.size();
    }
}
