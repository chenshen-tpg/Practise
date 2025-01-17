package LC_Questions.WholePackage.Stack.LC150.ValidParentheses;

import java.util.Stack;

public class MyVersion_Stack {
    public static void main(String[] args) {
        String s = "([])";
        MyVersion_Stack v = new MyVersion_Stack();
        System.out.println(v.helper(s));
    }

    public static boolean helper (String s) {
        Stack<Character> stack = new Stack<>();
        for (char ss : s.toCharArray()) {
            if (ss == ')' && !stack.isEmpty()) {
                if (stack.pop() != '(') return false;
            }
            else if (ss == '}' && !stack.isEmpty()) {
                if (stack.pop() != '{') return false;
            }
            else if (ss == ']' && !stack.isEmpty()) {
                if (stack.pop() != '[') return false;
            } else {
                stack.add(ss);
            }
        }
        return stack.isEmpty();
    }
}
