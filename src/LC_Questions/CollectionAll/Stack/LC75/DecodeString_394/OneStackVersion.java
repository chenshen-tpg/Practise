package LC_Questions.CollectionAll.Stack.LC75.DecodeString_394;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OneStackVersion {
    public static void main(String[] args) {
        String s = "3[a]2[bc]"; //"aaabcbc"
        String s1 = "13[a2[c]]"; //"accaccacc"
        String s2 = "2[abc]3[cd]ef"; //abcabccdcdcdef
        System.out.println(decodeString(s));
    }


    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                List<Character> decodedString = new ArrayList<>();
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                stack.pop();
                int k = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
