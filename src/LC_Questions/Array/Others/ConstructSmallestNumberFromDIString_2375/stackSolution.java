package LC_Questions.Array.Others.ConstructSmallestNumberFromDIString_2375;

import java.util.Stack;

public class stackSolution {
    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        stackSolution solution = new stackSolution();
        solution.smallestNum(pattern);
    }
    public String smallestNum (String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i <= pattern.length(); i++) {
            numStack.push(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!numStack.isEmpty()) {
                    result.append(numStack.pop());
                }
            }
        }
        return result.toString();
    }
}
