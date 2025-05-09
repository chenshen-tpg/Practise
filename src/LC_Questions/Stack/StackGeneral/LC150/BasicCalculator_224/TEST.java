package LC_Questions.Stack.StackGeneral.LC150.BasicCalculator_224;

import java.util.Stack;

public class TEST {

    public static void main(String[] args) {
        String s = "1-(  2-4   -2)";
        System.out.println(calculate(s));
    }
    public static int calculate(String s) {
        int ans = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
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


}
