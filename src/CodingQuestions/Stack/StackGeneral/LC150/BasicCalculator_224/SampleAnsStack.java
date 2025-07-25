package CodingQuestions.Stack.StackGeneral.LC150.BasicCalculator_224;

import java.util.Stack;

public class SampleAnsStack {
    public static void main(String[] args) {
// Test case 1: Simple addition
        System.out.println(new SampleAnsStack().calculate("1 + 2")); // Expected: 3

// Test case 2: Addition and subtraction
        System.out.println(new SampleAnsStack().calculate("2-1+2")); // Expected: 3

// Test case 3: Parentheses
        System.out.println(new SampleAnsStack().calculate("(1+(4+5+2)-3)+(6+8)")); // Expected: 23

// Test case 4: Leading negative
        System.out.println(new SampleAnsStack().calculate("-2+ 1")); // Expected: -1

// Test case 5: Nested parentheses
        System.out.println(new SampleAnsStack().calculate("2-(5-6)")); // Expected: 3

// Test case 6: Multiple digits
        System.out.println(new SampleAnsStack().calculate("10 + (2 - 3)")); // Expected: 9

// Test case 7: Spaces
        System.out.println(new SampleAnsStack().calculate(" 7 - ( 3 + 2 ) ")); // Expected: 2
    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0, sign = 1, result = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}
