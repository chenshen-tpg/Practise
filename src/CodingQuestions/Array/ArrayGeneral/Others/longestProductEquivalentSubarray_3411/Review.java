package CodingQuestions.Array.ArrayGeneral.Others.longestProductEquivalentSubarray_3411;

public class Review {
    public static void main(String[] args) {
        System.out.println(lcm(24, 32));
    }
    public static int gcd (int a, int b) {
        if (b == 0)  {
            return a;
        }
        return gcd (b, a % b);
    }
    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}



