package CodingQuestions.Algorithms.Array.ArrayGeneral.CountComplete_2799;

public class LoopTest {
    public static void main(String[] args) {
        int n = 4, count = 0;
        while (n > 0) {
            count += n--;
        }
        System.out.println(count);
    }
}
