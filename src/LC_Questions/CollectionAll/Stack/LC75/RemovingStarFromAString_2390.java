package LC_Questions.CollectionAll.Stack.LC75;

import java.util.Stack;

public class RemovingStarFromAString_2390 {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(method(s));
    }
    public static String method (String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }

        }
        StringBuilder result = new StringBuilder();
        for (Character ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }
}
