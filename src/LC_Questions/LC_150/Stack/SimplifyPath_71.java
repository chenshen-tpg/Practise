package LC_Questions.LC_150.Stack;

import java.util.Stack;

public class SimplifyPath_71 {
    public static void main(String[] args) {
        SimplifyPath_71 sp = new SimplifyPath_71();
        String path = "/a//b////c/d//././/..";
        System.out.println(sp.simplifyPath(path));
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
