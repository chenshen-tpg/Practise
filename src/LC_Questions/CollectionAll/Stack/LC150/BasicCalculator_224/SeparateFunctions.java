package LC_Questions.CollectionAll.Stack.LC150.BasicCalculator_224;

public class SeparateFunctions {
    public static void main(String[] args) {

    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '(' || c == ')';
    }
    public static void method1GetTheDigit(String s) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            } else if (number.length() > 0) {
                System.out.println(number.toString());
                number.setLength(0);
            }
        }
        if (number.length() > 0) {
            System.out.println(number.toString());
        }
    }
    public static void method2GetTheDigit(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sum = sum * 10 + (c - '0');
            } else {
                System.out.println(sum);
                sum = 0;
            }
        }
        if (sum > 0) {
            System.out.println(sum);
        }
    }
}
