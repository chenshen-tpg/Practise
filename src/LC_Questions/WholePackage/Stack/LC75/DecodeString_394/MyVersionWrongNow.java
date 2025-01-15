package LC_Questions.WholePackage.Stack.LC75.DecodeString_394;

import java.util.Stack;

public class MyVersionWrongNow {
    public static void main(String[] args) {
        String s = "3[a]2[bc]"; //"aaabcbc"
        String s1 = "3[a2[c]]"; //"accaccacc"
        String s2 = "2[abc]3[cd]ef"; //abcabccdcdcdef
        System.out.println(helper(s));
    }

    public static String helper (String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stack.add(Integer.valueOf(s.charAt(i)));
            }
            String temp = "";
            int multiplayer = 0;
            if (Character.isAlphabetic(s.charAt(i))) {
                multiplayer = stack.pop();
            }
            while (Character.isAlphabetic(s.charAt(i))) {
                i++;
                temp += s.charAt(i);
            }
            sb.append(temp.repeat(multiplayer));
        }
        return sb.toString();
    }
}
