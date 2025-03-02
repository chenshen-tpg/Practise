package LC_Questions.Stack.LC150.EvaluateReversePlishNotation_150;

import java.util.Stack;

public class StackEquals {
    public static void main(String[] args) {
        String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        StackEquals solution = new StackEquals();
        System.out.println(solution.evalRPN(tokens));
    }

    public int evalRPN (String [] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!"+-*/".contains(token)) stack.push(Integer.valueOf(token));
            else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(cal(token, num1, num2));
            }
        }
        return stack.pop();
    }


    public int cal (String op, int i, int j) {
        if ("+".equals(op)) return i + j;
        else if ("-".equals(op)) return i - j;
        else if ("*".equals(op)) return i * j;
        else if ("/".equals(op)) return i / j;
        return 0;
    }
}
