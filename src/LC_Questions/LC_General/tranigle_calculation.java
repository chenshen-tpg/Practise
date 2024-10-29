package LC_Questions.LC_General;

public class tranigle_calculation {
    public static void main(String[] args) {
        int[][] tranigle = {{2},{3,4},{6,5,7},{4,1,8,3}};
        int [] table  = new int [tranigle.length+1];
        for (int row = tranigle.length - 1; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int remain = Math.min(table[col], table[col + 1]);
                table [col] = tranigle[row][col] +remain;
            }
        }
        System.out.println(table [0]);
    }
}
