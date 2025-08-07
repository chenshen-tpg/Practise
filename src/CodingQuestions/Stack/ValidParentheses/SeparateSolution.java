package CodingQuestions.Stack.ValidParentheses;

import java.util.Stack;

public class SeparateSolution {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.isEmpty()) {
                char last = stack.peek();
                if (isPair(last, cur)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(cur);
        }

        return stack.isEmpty();
    }

    private boolean isPair(char last, char cur) {
        return (last == '(' && cur == ')') ||
                (last == '{' && cur == '}') ||
                (last == '[' && cur == ']');
    }
}
