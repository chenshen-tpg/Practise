package CodingQuestions.Array.ArrayGeneral.PerformStringShifts_1427;

public class MoveFrontEnd {
    public static void main(String[] args) {
        MoveFrontEnd solution = new MoveFrontEnd();
//        solution.helper("abc", new int [][] {{1,1},{1,1},{0,2},{0,3}});
        solution.helper("abc", new int [][] {{0,1},{1,2}});
    }
    public String helper(String string, int [][] arr) {
        int len = string.length();
        for (int[] move : arr) {
            int direction = move[0];
            int amount = move[1] % len;
            if (direction == 0) {
                string = string.substring(amount) + string.substring(0, amount);
            } else {
                string = string.substring(len - amount) + string.substring(0, len - amount);
            }
        }
        return string;
    }
}
