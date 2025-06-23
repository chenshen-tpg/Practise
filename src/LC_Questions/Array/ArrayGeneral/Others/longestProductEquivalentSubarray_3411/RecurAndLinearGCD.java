package LC_Questions.Array.ArrayGeneral.Others.longestProductEquivalentSubarray_3411;

public class RecurAndLinearGCD {

    public static void main(String[] args) {

    }

    private static int gcdLiner(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
