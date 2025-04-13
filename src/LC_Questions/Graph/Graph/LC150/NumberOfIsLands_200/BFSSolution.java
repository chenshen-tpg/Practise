package LC_Questions.Graph.Graph.LC150.NumberOfIsLands_200;



public class BFSSolution {

    public static void main(String[] args) {
        char [][] island = {{1,1,1,1,1,1},{1,0,0,0,0,0},{1,0,0,0,0,0},{1,0,0,0,0,0},{1,0,0,0,0,0}};
        BFSSolution solution = new BFSSolution();
        System.out.println(solution.bfs(island));
    }

    public int bfs(char[][] island) {
        int count = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j] == '1') {
                    count++;
                    helper(island, i, j);
                }
            }
        }
        return count;
    }
    public static void helper(char[][] grid, int i , int j){
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != '1'){
            return;
        } else {
            grid[i][j] = '0';
            helper(grid, i, j + 1);
            helper(grid,i + 1, j);
            helper(grid, i,j - 1);
            helper(grid,i - 1, j);
        }
    }
}
