package CodingQuestions.OOP.Snake_353;

import java.util.LinkedList;
import java.util.Queue;

public class DesignSnakeGame_NewVersion {

        Queue<Integer> q;
        int[][] foods;
        int foodIndex;
        int width, height;
        int row, col;

        public DesignSnakeGame_NewVersion(int width, int height, int[][] food) {
            q = new LinkedList();
            q.offer(0);
            foods = food;
            foodIndex = 0;
            this.width = width;
            this.height = height;
            row = 0;
            col = 0;
        }
        public int move(String direction) {
            if(direction.equals("U")){
                row --;
            }else if(direction.equals("D")){
                row ++;
            }else if(direction.equals("L")){
                col --;
            }else if(direction.equals("R")){
                col ++;
            }
            int head = row * width + col;
            if (head != q.peek() && q.contains(head)) {
                return -1;
            }
            if (row >= 0 && row < height && col >= 0 && col < width) {
                q.offer(head);
                if (foodIndex < foods.length && row == foods[foodIndex][0] && col == foods[foodIndex][1]) {
                    foodIndex ++;
                } else {
                    q.poll();
                }
                return foodIndex;
            }
            return -1;
        }

}
