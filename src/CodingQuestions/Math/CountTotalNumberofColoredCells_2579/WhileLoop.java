package CodingQuestions.Math.CountTotalNumberofColoredCells_2579;

public class WhileLoop {
    public static void main(String[] args) {

    }


    public long coloredCells(int n) {
        long res = 1;
        int round = 4;
        while (n > 0) {
            res += round;
            round += 4;
            n--;
        }
        return res;
    }

}
