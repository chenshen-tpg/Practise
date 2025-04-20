package LC_Questions.Stack.PremiumAlgo100.TernaryExpressionParser_439;

import java.util.Stack;

public class GPTfixed {
    public static void main(String[] args) {
        GPTfixed solution = new GPTfixed();
        System.out.println(solution.parseTernary("T?2:3"));     // Output: 2
        System.out.println(solution.parseTernary("F?T:F"));     // Output: F
        System.out.println(solution.parseTernary("T?T?F:5:3")); // Output: F
        System.out.println(solution.parseTernary("F?1:T?4:5")); // Output: 5
    }
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char cur = expression.charAt(i);
            if (stack.isEmpty()) {
                stack.push(cur);
            } else if (cur == ':') {
                stack.push(cur);
            } else if (cur == '?') {
                char falseVal = stack.pop();
                stack.pop();
                char trueVal = stack.pop();
                char condition = expression.charAt(i - 1);
                i--;
                if (condition == 'F') {
                    stack.push(trueVal);
                } else {
                    stack.push(falseVal);
                }
            } else {
                stack.push(cur);
            }
        }
        return String.valueOf(stack.pop());
    }
}
