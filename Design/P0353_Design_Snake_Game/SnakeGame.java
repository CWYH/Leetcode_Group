import java.util.*;

/**
 * 353. Design Snake Game -- Medium
 */

class SnakeGame {
    
    private List<int[]> snake = new LinkedList<>();
    // private HashSet<int[]> foods = new HashSet<>();
    private int[][] food;
    private int foodIndex = 0;
    private int width = 0;
    private int height = 0;
    private int score = 0;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        int[] pos = {0, 0};
        snake.add(0, pos);
        this.food = food;
        this.width = width;
        this.height = height;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] curPos = snake.get(0);
        int[] nextPos = new int[2];
        nextPos[0] = curPos[0];
        nextPos[1] = curPos[1];
        if (direction.equals("L")) {
            nextPos[1]--;
        } else if (direction.equals("R")) {
            nextPos[1]++;
        } else if (direction.equals("U")) {
            nextPos[0]--;
        } else {
            nextPos[0]++;
        }

        // the snake collides with border
        if (nextPos[0] < 0 || nextPos[0] >= height || nextPos[1] < 0 || nextPos[1] >= width) {
            return -1;
        }



        if (foodIndex < food.length && nextPos[0] == food[foodIndex][0] && nextPos[1] == food[foodIndex][1]) {
            snake.add(0, nextPos);
            score++;
            foodIndex++;
            return score;
        }


        // 判断的关键点在于，先移除蛇的尾部，再判断蛇头会不会撞到
        snake.remove(snake.size() - 1);

        // the snake collides with itself
        for (int[] p : snake) {
            if (p[0] == nextPos[0] && p[1] == nextPos[1]) {
                return -1;
            }
        }

        snake.add(0, nextPos);
        
        return score;
    }

    public static void main(String[] args) {
        int width = 3;
        int height = 2;
        int[][] food = {{1, 2}, {0, 1}};
        SnakeGame sg = new SnakeGame(width, height, food);
        System.out.println(sg.move("R"));
        System.out.println(sg.move("D"));
        System.out.println(sg.move("R"));
        System.out.println(sg.move("U"));
        System.out.println(sg.move("L"));
        System.out.println(sg.move("U"));
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */