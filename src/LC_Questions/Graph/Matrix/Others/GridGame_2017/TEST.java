package LC_Questions.Graph.Matrix.Others.GridGame_2017;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.helper(new int[][]{{2, 5, 4}, {1, 5, 1}});
    }

    public int helper (int [][] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] < arr[i][1]) arr[i][0] = 0;
        }

        return res;
    }
}
