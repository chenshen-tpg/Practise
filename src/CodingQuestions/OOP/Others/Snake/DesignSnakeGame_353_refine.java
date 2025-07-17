package CodingQuestions.OOP.Others.Snake;

import java.util.Deque;
import java.util.LinkedList;


class DesignSnakeGame_353_refine {
    class point {
        int r, c;
        public point(int r,int c) {
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) {

    }

    Deque<point> snake;
    int row,col,r,c,k;
    int[][] food;

    public DesignSnakeGame_353_refine(int width, int height, int[][] food) {
        row=height;
        col=width;
        this.food=food;
        snake = new LinkedList<>();
        snake.offerFirst(new point(0,0));
        k=0;
    }

    public int move(String direction) {
        point head = snake.peekFirst();
        point newHead = new point(head.r,head.c);
        point tail= snake.pollLast();
        if (direction.equals("U")) {
            newHead.r--;
        }
        else if(direction.equals("L")) {
            newHead.c--;
        }
        else if(direction.equals("R")) {
            newHead.c++;
        }
        else if(direction.equals("D")) {
            newHead.r++;
        }

        if (newHead.r < 0 || newHead.r >= row ||newHead.c < 0||newHead.c >= col)
            return -1;

        if (isDead(newHead)) return -1;
        snake.offerFirst(newHead);
        if (k < food.length && food[k][0] == newHead.r && food[k][1] == newHead.c) {
            k++;
            snake.offerLast(tail);
        }
        return k;
    }

    public boolean isDead(point newHead){
        for (point s:snake) {
            if (s.r == newHead.r && s.c == newHead.c)
                return true;
        }
        return false;
    }
}