package CodingQuestions.Math.Others.PowerOfTwo_231;

public class WhileLoop {
    public static void main(String[] args) {
        isPowerOfTwo(16);
    }
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
