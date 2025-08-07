package CodingQuestions.Stack.BasicCalculator_227;

public class SampleAns2 {
    int idx;

    public int calculate(String s) {
        idx = 0;
        return calc(s);
    }
    private int calc(String s) {
        int res = 0, num = 0, sign = 1;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            else if (c == '(') num = calc(s); // ( is start of a new sub-problem, Let recursion solve the sub-problem
            else if (c == ')') return res + sign * num;
            else if (c == '+' || c == '-') { // only when we meet a new sign, we know a while number has been read
                res += sign * num;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        return res + sign * num; // last number is not processed yet
    }
}
