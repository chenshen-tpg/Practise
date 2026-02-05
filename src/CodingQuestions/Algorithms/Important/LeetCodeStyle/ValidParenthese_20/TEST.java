package CodingQuestions.Algorithms.Important.LeetCodeStyle.ValidParenthese_20;

import java.util.Stack;

public class TEST {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char [] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            char temp = c[i];
            if (!stack.isEmpty() && temp == ')' ) {
                if (stack.pop() != '(') {
                    return false;
                }
            }
            else if (!stack.isEmpty() && temp == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            }
            else if (!stack.isEmpty() && temp == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            }
            else {
                stack.add(temp);
            }
        }
        return stack.isEmpty();
    }
}
