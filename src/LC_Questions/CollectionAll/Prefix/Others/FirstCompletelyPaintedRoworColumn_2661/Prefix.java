package LC_Questions.CollectionAll.Prefix.Others.FirstCompletelyPaintedRoworColumn_2661;

import java.util.HashMap;

public class Prefix {

    public static void main(String[] args) {
        Prefix h = new Prefix();
        int[] arr2 = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat2 = {
                {3, 2, 5},
                {1, 4, 6},
                {8, 7, 9}
        };

        System.out.println(h.firstCompleteIndex(arr2, mat2)); // Expected output: 5
    }


    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> mp = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                mp.put(mat[i][j], new int[]{i, j});
            }
        }
        int a[] = new int[m];
        int b[] = new int[n];
        for (int i = 0; i < arr.length; i++){
            int c[] = mp.get(arr[i]);
            a[c[0]]++;
            b[c[1]]++;
            if (a[c[0]] == n || b[c[1]] == m) return i;
        }
        return -1;
    }
}
