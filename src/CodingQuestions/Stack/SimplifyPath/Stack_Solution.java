package CodingQuestions.Stack.SimplifyPath;

import java.util.Stack;

public class Stack_Solution {
    public static void main(String[] args) {
        Stack_Solution sp = new Stack_Solution();
        String path = "/home/user/Documents/../Pictures";
        System.out.println(sp.SimplifyPathMyVersion(path));
    }

    public String SimplifyPathMyVersion (String path) {
        String [] simps = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String simp : simps) {
            if ("..".equals(simp)) {
                if (!stack.isEmpty()) stack.pop();
            } else if (".".equals(simp) || "".equals(simp)) {
                continue;
            } else {
                stack.add(simp);
            }
        }
        StringBuilder sb = new StringBuilder();
        // TIPs: we can use loop to iterate stack rather than pop them up
        // There is no pop all as well.
        for (String s:stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }

}
