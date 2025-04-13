package LC_Questions.Array.ArrayGeneral.LC75.GreatestCommonDivisorOfStrings_1071;

public class Review {
    public static void main(String[] args) {
        System.out.println(gcd(10,5));
    }

    public static int gcd (int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
}
