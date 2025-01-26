package LC_Questions.WholePackage.Graph.Others;



public class NumberOfIslands_200 {
    public static void main(String[] args) {

    }

    public int islands(char[][] island) {
        int count = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j] == '1') {
                    count++;
                    helper(island, i ,j);
                }
            }
        }
        return count;
    }
    public static void helper(char[][] grid, int i , int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] !='1'){
            return;
        } else {
            grid[i][j] = '0';
            helper(grid,i,j+1);
            helper(grid,i+1,j);
            helper(grid,i,j-1);
            helper(grid,i-1,j);
        }
    }
}
