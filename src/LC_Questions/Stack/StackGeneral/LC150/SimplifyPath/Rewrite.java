package LC_Questions.Stack.StackGeneral.LC150.SimplifyPath;

import java.util.Stack;

public class Rewrite {
    public static void main(String[] args) {
        Rewrite sp = new Rewrite();
        String path = "/.../a/../b/c/../d/./";
        System.out.println(sp.helper(path));
    }

    public String helper (String s) {
        StringBuilder ans = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String [] filter = s.split("/");
        for (String f : filter) {
            if (".".equals(f) || "".equals(f)) {
                continue;
            } else if ("..".equals(f)) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.add(f);
            }
        }
        for (String sta : stack) {
            ans.append("/");
            ans.append(sta);
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}
