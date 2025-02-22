package LC_Questions.CollectionAll.Stack.Others.TheKthLexicographicalStringofAllHappyString_1415;

import java.util.Stack;

public class StackSolution {

    public static void main(String[] args) {

    }

    public String getHappyString(int n, int k) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        stack.push("");
        while (stack.size() > 0) {
            String cur = stack.pop();
            if (cur.length() == n) {
                i++;
                if (i == k) return cur;
                continue;
            }
            for (char j = 'c'; j >= 'a'; j--) {
                if (cur.length() == 0 || cur.charAt(cur.length() - 1) != j) {
                    stack.push(cur + j);
                }
            }
        }
        return "";
    }

}
