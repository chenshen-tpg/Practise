package LC_Questions.WholePackage.Stack;

import java.util.Stack;

public class SimplifyPath_71 {
    public static void main(String[] args) {
        SimplifyPath_71 sp = new SimplifyPath_71();
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
        // we can use loop to iterate stack rather than pop them up
        // there is no pop all as well.
        for (String s:stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
    public String simplifyPath(String path) {

        Stack<String> sk = new Stack();
        String[] cs = path.split("/");
        for (String c : cs) {
            if (".".equals(c) || c.isEmpty()){
                continue;
            }else if ("..".equals(c)){
                if (!sk.isEmpty()){
                    sk.pop();
                }
            } else {
                sk.add(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String s : sk) {
            ans.append("/");
            ans.append(s);
        }
        return ans.length() > 0 ? ans.toString() : "/";
    }
}
