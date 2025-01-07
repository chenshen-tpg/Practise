package LC_Questions.ClassicQ;

import java.util.Stack;

public class BasicCalculatorII_227 {
    public static void main(String[] args) {
        BasicCalculatorII_227 calculator = new BasicCalculatorII_227();
        System.out.println(calculator.helper("3+2*2")); // Output: 7
    }
    private int helper(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        int ans = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (isOperator(c) || i == s.length() - 1) {
                if (operator == '+') st.push(num);
                else if (operator == '-') st.push(-num);
                else if (operator == '*') st.push(st.pop() * num);
                else if (operator == '/') st.push(st.pop() / num);
                num = 0;
                operator = c;
            }
        }
        while (!st.isEmpty()) ans += st.pop();
        return ans;
    }
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
