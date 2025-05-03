package LC_Questions.Stack.StackGeneral.Others;

import java.util.Stack;

public class CheckifaParenthesesStringCanBeValid_2116 {
    public static void main(String[] args) {
        String s = "))()))";
        String locked = "010100";
        TwoStackToTrack(s, locked);
    }

//    public static boolean Count(String s , String locked) {
//        int length = s.length();
//        if (length % 2 == 1) return false;
//        int countOpen = 0;
//        int countUnlock = 0;
//
//
//
//
//    }

    public static boolean TwoStackToTrack(String s , String locked) {
        int length = s.length();
        if (length % 2 == 1) return false;
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0') unlocked.add(i);
            else if (c == '(') {
                openBrackets.add(i);
            } else {
                if (!openBrackets.isEmpty()) {
                    openBrackets.pop();
                } else if (!unlocked.isEmpty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }
        while (!openBrackets.isEmpty() && !unlocked.isEmpty() && openBrackets.peek() < unlocked.peek()){
            openBrackets.pop();
            unlocked.pop();
        }
        if (!openBrackets.empty()) {
            return false;
        }
        return true;
    }
}
