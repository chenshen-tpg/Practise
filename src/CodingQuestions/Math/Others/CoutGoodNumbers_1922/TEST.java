package CodingQuestions.Math.Others.CoutGoodNumbers_1922;

public class TEST {
    public static void main(String[] args) {

    }
    long mod = 1000000007;

    public int countGoodNumbers(long n) {
        return (int) ((helper(5, (n + 1) / 2) * helper(4, n / 2)) % mod);
    }

    public long helper(int x, long y) {
        long ret = 1;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) ret = (ret * mul) % mod;
            mul = (mul * mul) % mod;
            y /= 2;
        }
        return ret;
    }
}
