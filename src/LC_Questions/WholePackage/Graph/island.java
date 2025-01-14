package LC_Questions.WholePackage.Graph;

public class island {
    public static void main(String[] args) {
        int land = 0;
        int [][] island = {{1,1,1,1,1,1},{1,0,0,0,0,0},{1,0,0,0,0,0},{1,0,0,0,0,0},{1,0,0,0,0,0}};
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if(island[i][j] == 1) {
                    finder(island,i,j);
                    land++;
                }
            }
        }
        System.out.println(land);
    }
    public static void finder (int [][] island, int i, int j) {
        if( i< 0 || i>= island.length || j < 0 || j >= island[i].length || island[i][j] !=1) return;
            island[i][j] = 0;
            finder(island,i+1,j);
            finder(island,i-1,j);
            finder(island,i,j+1);
            finder(island,i,j-1);
    }
}
