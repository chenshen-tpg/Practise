package CodingQuestions.Stack.StackGeneral.Others.MinimumRemovetoMakeValidParentheses_1249;

import java.util.Stack;

public class StackSolution {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }
    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
           if (c == '(') {
               stack.add('(');
               sb.append(c);
           } else if (c == ')'){
               if (!stack.isEmpty()) {
                   sb.append(c);
                   stack.pop();
               }
           } else {
               sb.append(c);
           }
        }
        while (!stack.isEmpty()) {
            int indexToRemove = sb.lastIndexOf("(");
            if (indexToRemove != -1) {
                sb.deleteCharAt(indexToRemove);
                stack.pop();
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
