package LC_Questions.AtlanssianQ.Snake;

import java.util.LinkedList;

public class DesignSnakeGame_353 {
    int width;
    int height;
    int[][] food;
    class Point{
        int i;
        int j;
        Point(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    int k = 0;
    LinkedList<Point> snake;

    public static void main(String[] args) {
        DesignSnakeGame_353 game = new DesignSnakeGame_353(3, 3, new int[][]{{2, 0}, {0, 0}, {0, 2}, {0, 1}, {2, 2}, {0, 1}});

        System.out.println(game.move("D")); // Expected output: 0
        System.out.println(game.move("D")); // Expected output: 1
        System.out.println(game.move("R")); // Expected output: 1
        System.out.println(game.move("U")); // Expected output: 1
        System.out.println(game.move("U")); // Expected output: 1
        System.out.println(game.move("L")); // Expected output: 2
        System.out.println(game.move("D")); // Expected output: 2
        System.out.println(game.move("R")); // Expected output: 2
        System.out.println(game.move("R")); // Expected output: 2
        System.out.println(game.move("U")); // Expected output: 2
        System.out.println(game.move("L")); // Expected output: 2
        System.out.println(game.move("L")); // Expected output: 2
        System.out.println(game.move("D")); // Expected output: 2
        System.out.println(game.move("R")); // Expected output: 2
        System.out.println(game.move("U")); // Expected output: 2
    }

    public DesignSnakeGame_353(int width, int height, int[][] food) {
        this.width=width;
        this.height=height;
        this.food=food;
        this.k=0;
        this.snake=new LinkedList<>();
        snake.addFirst(new Point(0,0));
    }

    public int move(String direction) {
        Point head = snake.getFirst();
        Point newHead = new Point(head.i, head.j);
        Point tail = snake.removeLast();
        if (direction.equals("U")) {
            newHead.i--;
        } else if(direction.equals("D")) {
            newHead.i++;
        } else if(direction.equals("L")) {
            newHead.j--;
        } else {
            newHead.j++;
        }

        /***
         * The contains method may not work correctly because the Point class does not override the equals and hashCode methods.
         * Without these overrides, the contains method uses the default Object class's equals method,
         * which checks for reference equality rather than value equality.
         * The isDead method works because it explicitly checks the values of the r and c fields of each point object in the snake deque.  To fix the contains method,
         * you need to override the equals and hashCode methods in the point class. Here is how you can do it:
         */

        if (newHead.i < 0 || newHead.i == height || newHead.j < 0 || newHead.j == width || snake.contains(newHead)) return -1;
        snake.addFirst(newHead);
        if (k < food.length && food[k][0] == newHead.i && food[k][1] == newHead.j) {
            snake.addLast(tail);
            k++;
        }
        return k;
    }

}
