package LC_Questions.WholePackage.Stack.LC150;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        String[] tokens1 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evaluate(tokens1));
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
    public int evalRPN(String[] tokens) {
        int currentPosition = 0;
        int length = tokens.length;
        while (length > 1) {
            while (!"+-*/".contains(tokens[currentPosition])) {
                currentPosition++;
            }
            int number1 = Integer.parseInt(tokens[currentPosition - 2]);
            int number2 = Integer.parseInt(tokens[currentPosition - 1]);
            int newValue = 0;
            switch (tokens[currentPosition]) {
                case "+":
                    newValue = number1 + number2;
                    break;
                case "-":
                    newValue = number1 - number2;
                    break;
                case "*":
                    newValue = number1 * number2;
                    break;
                case "/":
                    newValue = number1 / number2;
                    break;
            }
            tokens[currentPosition] = Integer.toString(newValue);
            delete2AtIndex(tokens, currentPosition - 2, length);
            currentPosition--;
            length -= 2;
        }
        return Integer.parseInt(tokens[0]);
    }
    private void delete2AtIndex(String[] tokens, int d, int length) {
        for (int i = d; i < length - 2; i++) {
            tokens[i] = tokens[i + 2];
        }
    }
}
