package LC_Questions.CollectionAll.Matrix.Others;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze_1926 {
    public static void main(String[] args) {
        String [][] maze = {{"+","+","+"},{".",".","."},{"+","+","+"}};
        int [] entrance = {1,0};
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == entrance[0] && j == entrance[1]){
                    System.out.println(maze[i][j]);
                }
            }
        }
    }

    public static boolean helper (int[][]maze,int x, int y){
        if (x > maze[0].length || y > maze[0].length) {
            return false;
        }
        if (".".equals(maze[x][y])) {

        }
        helper(maze,x+1,y);
        helper(maze,x-1,y);
        helper(maze,x,y+1);
        helper(maze,x,y-1);
        return true;
    }
    public static void remover (){
        String s = "[[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]]";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='[') {
                sb.append("{");
            }else if (s.charAt(i)==']'){
                sb.append("}");
            }else{
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
    public static int xx(int [][] maze, int [] entrance) {
        int rows = maze.length, cols = maze[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0});
        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int currRow = currState[0], currCol = currState[1], currDistance = currState[2];
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];
                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols
                        && maze[nextRow][nextCol] == '.') {
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1)
                        return currDistance + 1;
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, currDistance + 1});
                }
            }
        }
        return -1;
    }
    
}
