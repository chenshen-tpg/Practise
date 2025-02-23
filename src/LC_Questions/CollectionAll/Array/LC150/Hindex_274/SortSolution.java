package LC_Questions.CollectionAll.Array.LC150.Hindex_274;

import java.util.Arrays;

public class SortSolution {

    public static void main(String[] args) {

    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length-i-1] > i) {
            i++;
        }
        return i;
    }
}
