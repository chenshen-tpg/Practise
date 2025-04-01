package LC_Questions.Array.PremiumAlgo100.ReverseWordsInAStringII;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Test solution = new Test();
        solution.reverseWords(new char [] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
    }
    public void reverseWords(char[] s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                stack.add(temp);
                temp = new StringBuilder();
            } else if (Character.isLetter(s[i])) {
                temp.append(s[i]);
            } else {
                temp.append(s[i]);
            }
        }
        if (temp.length() > 0) stack.add(temp);
        int index = 0;
        while (!stack.isEmpty()) {
            StringBuilder sb = stack.pop();
            for (int j = 0; j < sb.length(); j++) {
                s[index++] = sb.charAt(j);

            }
        }
        System.out.println(s);
    }
}
