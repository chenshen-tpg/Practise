package LC_Questions.Array.LC75.GreatestCommonDivisorOfStrings_1071;

public class IntroduceGCD {
    public static void main(String[] args) {

    }
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int gcdRecursive(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
