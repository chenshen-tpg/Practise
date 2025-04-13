package LC_Questions.Graph.Graph.LC75.NumberOfProvinces_547;

import java.util.Arrays;

public class BruteForce {


    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
        int[][] testCase1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(bruteForce.method(testCase1)); // Expected output: 2

        int[][] testCase2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(bruteForce.method(testCase2)); // Expected output: 3

        int[][] testCase3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println(bruteForce.method(testCase3)); // Expected output: 1

        int[][] testCase4 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(bruteForce.method(testCase4));
    }

    public static int method(int[][] arr) {
        int res = 0;
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                res++;
                markConnected(arr, vis, i);
            }
        }
        return res;
    }


    private static void markConnected(int[][] arr, boolean[] vis, int i) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[i][j] == 1 && !vis[j]) {
                vis[j] = true;
                markConnected(arr, vis, j);
            }
        }
    }
}
