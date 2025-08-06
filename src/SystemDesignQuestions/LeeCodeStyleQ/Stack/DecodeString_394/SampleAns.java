package SystemDesignQuestions.LeeCodeStyleQ.Stack.DecodeString_394;

import java.util.Stack;

public class SampleAns {
    public static void main(String[] args) {

    }
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack();
        Stack<String> cStack = new Stack();
        String temp = "";
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                numStack.push(num);
                cStack.push(temp);
                num = 0;
                temp = "";
            } else if (c == ']') {
                int curNum = numStack.pop();
                String prev = cStack.pop();
                temp = prev + repeat(temp,curNum);
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                temp += c;
            }
        }
        return temp;
    }
    public static String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
