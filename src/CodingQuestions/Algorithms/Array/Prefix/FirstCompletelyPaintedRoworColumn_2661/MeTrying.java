package CodingQuestions.Algorithms.Array.Prefix.FirstCompletelyPaintedRoworColumn_2661;

import java.util.HashMap;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying h = new MeTrying();
        int[] arr2 = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat2 = {
                {3, 2, 5},
                {1, 4, 6},
                {8, 7, 9}
        };

        System.out.println(h.test(arr2, mat2)); // Expected output:
    }

    public static int test(int [] arr, int [][] mat) {
        HashMap<Integer,int[]> hm = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length ; j++) {
                hm.put(mat[i][j], new int [] {i, j});
            }
        }
        int [] r = new int [mat.length];
        int [] c = new int [mat[0].length];
        for (int i = 0; i < arr.length; i++) {
            int [] cur = hm.get(arr[i]);
            r[cur[0]]++;
            c[cur[1]]++;
            //row needs to fill with column vice versa
            if (r[cur[0]] == mat.length || c[cur[1]] == mat[0].length)
                return i;
        }


        return -1;
    }



}
