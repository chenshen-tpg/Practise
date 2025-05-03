package LC_Questions.Stack.StackGeneral.LC75.DecodeString_394;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Review {
    public static void main(String[] args) {
        String s = "3[a]2[bc]"; //"aaabcbc"
        String s1 = "3[a2[c]]"; //"accaccacc"
        String s2 = "2[abc]3[cd]ef"; //abcabccdcdcdef
        System.out.println(TwoStack(s));
    }


    public static String BruteForce(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //every [] will be treated as individual block
            if (s.charAt(i) == ']') {
                List<Character> de = new ArrayList<>();
                while (stack.peek() != '[') {
                    de.add(stack.pop());
                }
                stack.pop();
                int k = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = (stack.pop() - '0') * base + k;
                    base *= 10;
                }
                while (k != 0) {
                    for (int j = de.size() - 1; j >= 0; j--) stack.push(de.get(j));
                    k--;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return  stack.toString().replaceAll("[\\[\\], ]", "");
    }
    public static String TwoStack(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> character = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)){
                k = k * 10 + c - '0';
            }
            else if (c == '[') {
                count.push(k);
                character.push(sb);
                sb = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder decode = character.pop();
                for (int i = count.pop(); i > 0; i--){
                    decode.append(sb);
                }
                sb = decode;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
