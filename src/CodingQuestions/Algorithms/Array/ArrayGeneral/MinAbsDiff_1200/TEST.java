package CodingQuestions.Algorithms.Array.ArrayGeneral.MinAbsDiff_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] < minDiff) {
                minDiff = arr[i] - arr[i-1];
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]-arr[i-1] == minDiff) {
                List<Integer> temp = new ArrayList();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(temp);
            }

        }
        return res;
    }
}
