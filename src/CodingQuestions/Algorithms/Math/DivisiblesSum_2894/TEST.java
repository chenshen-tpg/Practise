package CodingQuestions.Algorithms.Math.DivisiblesSum_2894;

public class TEST {
    public static void main(String[] args) {

    }
    public int differenceOfSums(int n, int m) {
        int sumN = 0, sumM = 0;
        for (int i = 0; i <= n; i++) {
            if (i % m != 0) {sumN += i;}
            if (i % m == 0) {sumM += i;}
        }
        return sumN - sumM;
    }
}
