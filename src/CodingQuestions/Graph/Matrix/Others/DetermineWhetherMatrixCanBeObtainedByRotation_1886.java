package CodingQuestions.Graph.Matrix.Others;

public class DetermineWhetherMatrixCanBeObtainedByRotation_1886 {
    public static void main(String[] args) {
        DetermineWhetherMatrixCanBeObtainedByRotation_1886 d = new DetermineWhetherMatrixCanBeObtainedByRotation_1886();
        int[][] a = {
                {0,1},
                {1,0}
        };
        int[][] b = {
                {1,0},
                {0,1}
        };
        System.out.println(d.findRotation(a, b));
    }
    public boolean findRotation(int[][] a, int[][] b) {
        int n=a.length;
        int c90=0,c180=0,c270=0,c0=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(b[i][j]==a[i][j]) c0++;
                if(b[i][j]==a[n-j-1][i]) c90++;
                if(b[i][j]==a[n-i-1][n-j-1]) c180++;
                if(b[i][j]==a[j][n-i-1]) c270++;
            }
        }
        return c0 == n * n || c90 == n * n || c180 == n * n || c270 == n * n;
    }
}
