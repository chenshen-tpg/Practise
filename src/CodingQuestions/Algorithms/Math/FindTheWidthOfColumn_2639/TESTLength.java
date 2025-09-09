package CodingQuestions.Algorithms.Math.FindTheWidthOfColumn_2639;

public class TESTLength {
    public static void main(String[] args) {
        int a = 9, count = 0;
        while (a % 10 > 0) {
            a /= 10;
            count++;
        }
        System.out.println(count );
    }
}
