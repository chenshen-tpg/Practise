package LC_Questions.Prefix.Others.FindThePrefixCommonArrayOfTwoArrays_2657;

import java.util.HashSet;
import java.util.Set;

public class HashSetMethod {
    public static void main(String[] args) {
        int [] a = {1,3,2,4};
        int [] b = {3,1,2,4};
        System.out.println(findThePrefixCommonArray(a,b));
    }
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        Set<Integer> elementsInA = new HashSet<Integer>();
        Set<Integer> elementsInB = new HashSet<Integer>();
        for (int currentIndex = 0; currentIndex < n; ++currentIndex) {
            elementsInA.add(A[currentIndex]);
            elementsInB.add(B[currentIndex]);
            int commonCount = 0;
            for (int element : elementsInA) {
                if (elementsInB.contains(element)) {
                    ++commonCount;
                }
            }
            prefixCommonArray[currentIndex] = commonCount;
        }
        return prefixCommonArray;
    }
}
