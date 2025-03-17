package LC_Questions.BitManipulation.Ohters.DivideTwoIntegers_29;

public class test {
    public static void main(String[] args) {

    }
    public int divide(int dividend, int divisor) {
        long c = 0;
        long sign = 1;
        if (divisor == 1) return dividend;
        if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0)) sign = -1;
        long dr = Math.abs((long) divisor);
        long dd = Math.abs((long) dividend);
        for (int i = 30; i >= 0; i--) {
            if (dd > 0 && dd >= (dr << i)) {
                c += (1 << i);
                dd -= (dr << i);
            }
        }
        return (int) (c * sign);
    }
}
