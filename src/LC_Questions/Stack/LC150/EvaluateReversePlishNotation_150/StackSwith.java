package LC_Questions.Stack.LC150.EvaluateReversePlishNotation_150;

import java.util.Stack;

public class StackSwith {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        String[] tokens1 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evaluate(tokens));
    }

    public static int evaluate(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token:tokens) {
            if(!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));

            } else {
                int x1 = stack.pop();
                int x2 = stack.pop();
                int val = 0;
                val = applyOperator(x2, x1, token);
                stack.push(val);
            }
        }
        return stack.pop();
    }
    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}
