package Preparation.Specific.Canva.Programming.BasicCalculator;

import java.util.Stack;

public class BasicCal {
    public static void main(String[] args) {

    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int num = 0, sign = 1, res = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if (num != 0) {
            res += sign * num;
        }
        return res;
    }
}
