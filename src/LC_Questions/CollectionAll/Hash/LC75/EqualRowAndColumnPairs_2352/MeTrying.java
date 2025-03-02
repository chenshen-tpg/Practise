package LC_Questions.CollectionAll.Hash.LC75.EqualRowAndColumnPairs_2352;

import java.util.Arrays;
import java.util.HashMap;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying solution = new MeTrying();
        int [][] arr = new int [][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        solution.helper(arr);
    }

    public int helper (int [][] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                boolean flag = true;
                for (int k = 0; k < arr.length; k++) {
                    if (arr[i][k] != arr[k][j]) {
                        flag =false;
                        break;
                    }
                }
                ans += flag ? 1 : 0;
            }
        }
        return ans;
    }
    public int hmVersion(int [][] arr) {
        int ans = 0;
        int n = arr.length;
        HashMap<String, Integer> hm = new HashMap();
        for (int [] row : arr) {
            String temp = Arrays.toString(row);
            hm.put(temp, hm.getOrDefault(temp, 0) + 1);
        }
        for (int c = 0; c < n; c++) {
            int [] colArr = new int [n];
            for (int r = 0; r < n; r++) {
                colArr[r] = arr[r][c];
            }
            ans += hm.getOrDefault(Arrays.toString(colArr), 0);
        }
        return ans;
    }
}
