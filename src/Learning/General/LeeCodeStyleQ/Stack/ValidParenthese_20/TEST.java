package Learning.General.LeeCodeStyleQ.Stack.ValidParenthese_20;

import java.util.Stack;

public class TEST {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == ')'){
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (!stack.isEmpty() && c == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (!stack.isEmpty() && c == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
