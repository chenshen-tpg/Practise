package LC_Questions.Array.LC75.GreatestCommonDivisorOfStrings_1071;

public class GCD {

    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        GCD solution = new GCD();
        solution.gcdOfStrings(str1, str2);
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);

    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

}
