package CodingQuestions.Algorithms.Math.PowerOfTwo_231;

public class BitWise {
    public static void main(String[] args) {
        BitWise solution = new BitWise();
        solution.isPowerOfTwo(16);
    }
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}
