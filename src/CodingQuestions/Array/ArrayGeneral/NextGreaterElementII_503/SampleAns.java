package CodingQuestions.Array.ArrayGeneral.NextGreaterElementII_503;

import java.util.Stack;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= nums[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i % n] = nums[stack.peek() % n];
            } else {
                ans[i % n] = -1;
            }
            stack.push(i % n);
        }
        return ans;
    }
}
