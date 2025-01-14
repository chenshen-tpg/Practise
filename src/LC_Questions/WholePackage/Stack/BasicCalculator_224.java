package LC_Questions.WholePackage.Stack;

import java.util.Stack;

public class BasicCalculator_224 {
    int idx;

    public static void main(String[] args) {
        String s = "1-(  2-4   -2)";
        System.out.println(calculate(s));
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0;
        int sign = 1;
        for (int i = 0; i<s.length();i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = 10 * operand + (int) (ch - '0');
            } else if (ch == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result +(sign*operand);
    }
    public int recursiveSolution(String s) {
        idx = 0; // Initialization should be here
        return calc(s);
    }

    private int calc(String s) {
        int res = 0, num = 0, sign = 1;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            else if (c == '(') num = calc(s);
            else if (c == ')') return res + sign * num;
            else if (c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        return res + sign * num; // last number is not processed yet
    }
    public static int mostVotedSolution (String s) {
        int ans = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 +(c - '0');
            }
            else if (c == '+') {
                ans += sign * num;
                num = 0;
                sign = 1;
            }
            else if (c == '-') {
                ans += sign * num;
                num = 0;
                sign = -1;
            }
            else if (c == '(') {
                stack.push(ans);
                stack.push(sign);
                sign = 1;
                ans = 0;
            }
            else if (c == ')') {
                ans += sign * num;
                num = 0;
                ans *= stack.pop();
                ans += stack.pop();
            }
        }
        if(num != 0) ans += sign * num;
        return ans;
    }


    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '(' || c == ')';
    }
    public static void method1GetTheDigit(String s) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            } else if (number.length() > 0) {
                System.out.println(number.toString());
                number.setLength(0);
            }
        }
        if (number.length() > 0) {
            System.out.println(number.toString());
        }
    }
    public static void method2GetTheDigit(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sum = sum * 10 + (c - '0');
            } else {
                System.out.println(sum);
                sum = 0;
            }
        }
        if (sum > 0) {
            System.out.println(sum);
        }
    }
}
