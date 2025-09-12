package CodingQuestions.Math.CovertIntegerToSumOfTwo_1317;

public class TEST {
    public static void main(String[] args) {

    }
    
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            int j = n - i;
            if (helper(i) && helper(j)) {
                return new int [] {i,j} ;
            }
        }
        return new int []{};
    }

    public boolean helper (int n) {
        while (n > 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }
}
