package CodingQuestions.Algorithms.Array.ArrayGeneral.NextGreaterElementII_503;

import java.util.Arrays;
import java.util.Stack;

public class SampleAns2 {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();

        int i = 0;
        int flag = 0;
        while (i <= n && flag <= 1) {
            if (i == n) {
                i = 0;
                flag++;
            }
            if (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                result[st.pop()] = nums[i];
            } else if (flag == 0) {
                st.push(i);
                i++;
            } else {
                i++;
            }
        }
        return result;
    }
}
