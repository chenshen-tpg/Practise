package CodingQuestions.Algorithms.Stack.BasicCalculator_224;

public class SampleAnswerBest {
    public static void main(String[] args) {

    }

    int i = 0;

    public int calculate(String s) {
        int num = 0;
        int sign = 1;
        int ans = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            if (ch >= '0' && ch <= '9') {
                num = 10 * num + (ch - '0');
            } else if (ch == '(') {
                num = calculate(s);
            } else if (ch == '+' || ch == '-') {
                ans = ans + num * sign;
                num = 0;
                sign = ch == '+' ? 1 : -1;
            } else if (ch == ')') {
                return (ans = ans + num * sign);
            }
        }
        ans = ans + num * sign;
        return ans;
    }
}
