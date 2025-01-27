package LC_Questions.CollectionAll.Matrix;

public class RottingOranges_994 {

    public static void main(String[] args) {
        int min = 2;
        int [][] org = {{2,1,1},{0,1,1},{1,0,1}};
        for (int i = 0; i < org.length; i++) {
            for (int j = 0; j < org[i].length; j++) {
                if (org[i][j]==2) {
                    helper(i, j, org, min);
                }
            }
        }
        for (int i = 0; i < org.length; i++) {
            for (int j = 0; j < org[i].length; j++) {
                min = (Math.max(min,org[i][j]));
            }
        }
        System.out.println(min);
    }
    public static void helper (int i, int j, int [][] org, int min) {
        if (i < 0 || i >= org.length || j < 0 || j >= org[i].length || org[i][j] == 0) return;
        if (org[i][j] > 1 && org[i][j] < min) return;
            org[i][j] = min;
            min++;
            helper(i + 1, j, org, min);
            helper(i - 1, j, org, min);
            helper(i, j + 1, org, min);
            helper(i, j - 1, org, min);
//        }
    }
}
