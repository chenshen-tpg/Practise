package CodingQuestions.Stack.DailyTemperatures_739;

import java.util.Stack;

public class ModelAnswer {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] arr) {
        int [] ans = new int [arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] < temp) {
                int pre = stack.pop();
                ans[pre] = i - pre;
            }
            stack.add(i);
        }
        return ans;
    }
}
