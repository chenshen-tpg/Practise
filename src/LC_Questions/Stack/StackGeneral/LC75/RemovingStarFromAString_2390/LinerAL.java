package LC_Questions.Stack.StackGeneral.LC75.RemovingStarFromAString_2390;

import java.util.ArrayList;

public class LinerAL {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(method(s));
    }
    public static String method (String s) {
        ArrayList<Character> al = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!al.isEmpty() && s.charAt(i) == '*') {
                al.remove(al.size()-1);
            } else {
                al.add(s.charAt(i));
            }
        }
        String res = "";
        for (int i = 0; i < al.size(); i++) {
            res += al.get(i);
        }
        return res;
    }
}
