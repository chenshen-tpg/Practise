package CodingQuestions.Algorithms.Math.MinimumOperationsToMakeTheIntegerZero_2749;

public class TEST {
    public static void main(String[] args) {

    }
    public int makeTheIntegerZero(int num1, int num2) {
        int k = 1;
        while (true) {
            long x = num1 - (long) num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
            k++;
        }
    }
}
