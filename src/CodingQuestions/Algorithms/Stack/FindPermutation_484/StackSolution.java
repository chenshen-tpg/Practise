package CodingQuestions.Algorithms.Stack.FindPermutation_484;

import java.util.Stack;

public class StackSolution {

    public static void main(String[] args) {

    }

    public int[] findPermutation(String s) {
        int [] res = new int [s.length() + 1];
        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            stack.push(i + 1);
            if (s.charAt(i) == 'I') {
                while (!stack.isEmpty()) res[j++] = stack.pop();
            }
        }
        stack.push(s.length() + 1);
        while (!stack.isEmpty()) res[j++] = stack.pop();
        return res;
    }
}
