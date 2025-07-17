package CodingQuestions.Stack.StackGeneral.Others.MakeArrayIncreasing_3523;

import java.util.Stack;

public class TEST {
    public static void main(String[] args) {

    }
    public int maximumPossibleSize(int[] nums) {
        Stack<Integer> stack = new Stack();
        stack.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(stack.peek() <= nums[i]) stack.add(nums[i]);
        }
        return stack.size();
    }
}
