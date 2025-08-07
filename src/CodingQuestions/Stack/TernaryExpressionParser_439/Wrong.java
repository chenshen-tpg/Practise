package CodingQuestions.Stack.TernaryExpressionParser_439;

import java.util.Stack;

public class Wrong {
    public static void main(String[] args) {

    }
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        char temp = ' ';
        for (int i = expression.length() - 1; i >= 0 ; i--) {
            char cur = expression.charAt(i);
            if (cur == 'T' && i - 1 > 0 && expression.charAt(i - 1) == '?') {
                if (!stack.isEmpty())   {
                    temp = stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                stack.add(temp);

            } else if (cur == 'F' && i - 1 > 0 && expression.charAt(i - 1) == '?') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (Character.isLetterOrDigit(cur)){
                stack.add(cur);
            }
        }
        for (char remain : stack) sb.append(remain);
        return sb.toString();
    }
}
