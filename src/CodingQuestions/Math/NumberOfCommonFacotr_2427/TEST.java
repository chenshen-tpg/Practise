package CodingQuestions.Math.NumberOfCommonFacotr_2427;

public class TEST {
    public static void main(String[] args) {

    }
    public int commonFactors(int a, int b) {
        int count = 0;
        for (int i = 1; i <= Math.min(a,b);i++) {
            if (a % i == 0 && b % i == 0) count++;
        }
        return count;
    }
}
