package CodingQuestions.Algorithms.Array.ArrayGeneral.MinimumAmountOfTimeToFillCup_2335;

public class MathSolution {
    public static void main(String[] args) {

    }
    public int fillCups(int[] amount) {
        int max1 = Math.max(amount[0], Math.max(amount[1], amount[2]));
        int sum = amount[0] + amount[1] + amount[2];
        return Math.max(max1, (sum + 1) / 2);
    }
}
