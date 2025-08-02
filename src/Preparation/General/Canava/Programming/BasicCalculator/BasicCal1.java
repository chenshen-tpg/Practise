package Preparation.General.Canava.Programming.BasicCalculator;

import java.util.Stack;

public class BasicCal1 {
    public static void main(String[] args) {

    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        char op = '+';
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (op == '+') stack.push(cur);
                else if (op == '-') stack.push(-cur);
                else if (op == '*') stack.push(stack.pop() * cur);
                else if (op == '/') stack.push(stack.pop() / cur);
                cur = 0;
                op = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
