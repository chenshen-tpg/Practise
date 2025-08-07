package CodingQuestions.Math.PowerOfFour_342;

public class TEST {
    public static void main(String[] args) {

    }
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        while (n % 4 == 0) n /= 4;
        return n == 1;
    }
}
