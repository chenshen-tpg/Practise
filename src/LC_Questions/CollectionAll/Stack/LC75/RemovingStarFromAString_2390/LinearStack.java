package LC_Questions.CollectionAll.Stack.LC75.RemovingStarFromAString_2390;

import java.util.Stack;

public class LinearStack {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(method(s));
    }
    public static String method(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') stack.pop();
            else stack.add(c);
        }
        for(char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
