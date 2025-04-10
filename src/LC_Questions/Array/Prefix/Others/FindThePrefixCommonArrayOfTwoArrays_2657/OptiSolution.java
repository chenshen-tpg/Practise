package LC_Questions.Array.Prefix.Others.FindThePrefixCommonArrayOfTwoArrays_2657;

public class OptiSolution {


    public static void main(String[] args) {
        int [] a = {1,3,2,4};
        int [] b = {3,1,2,4};
        findThePrefixCommonArray(a, b);
    }
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        int[] frequency = new int[n + 1];
        int commonCount = 0;
        for (int currentIndex = 0; currentIndex < n; ++currentIndex) {
            frequency[A[currentIndex]] += 1;
            if (frequency[A[currentIndex]] == 2) ++commonCount;
            frequency[B[currentIndex]] += 1;
            if (frequency[B[currentIndex]] == 2) ++commonCount;
            prefixCommonArray[currentIndex] = commonCount;
        }
        return prefixCommonArray;
    }
}
