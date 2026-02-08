package Preparation.General.LeetCodeStyle.ValidParenthese_20;

import java.util.Stack;

public class TEST2 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char temp = stack.pop();
                if (c == ')' && temp != '(') return false;
                if (c == ']' && temp != '[') return false;
                if (c == '}' && temp != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
