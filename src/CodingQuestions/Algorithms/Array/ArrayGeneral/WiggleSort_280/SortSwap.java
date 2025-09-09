package CodingQuestions.Algorithms.Array.ArrayGeneral.WiggleSort_280;

import java.util.Arrays;

public class SortSwap {
    public static void main(String[] args) {
        helper(new int [] {3,5,2,1,6,4});
    }

    private static void helper(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length- 1; i += 2) {
            swap(nums, i , i + 1);
        }
        System.out.println(nums);
    }
    private static void swap (int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
