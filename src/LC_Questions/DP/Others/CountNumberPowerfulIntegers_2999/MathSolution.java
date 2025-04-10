package LC_Questions.DP.Others.CountNumberPowerfulIntegers_2999;


public class MathSolution {
    public long num (long start, long finish, int limit, String s) {
        return cal(Long.toString(finish), s, limit) - cal(Long.toString(start-1), s, limit);
    }

    public long cal(String x, String s, int limit) {
        if (x.length() < s.length()) return 0;
        if (x.length() == s.length()) return x.compareTo(s) >= 0 ? 1: 0;
        long count = 0;
        int len = x.length() - s.length();
        for (int i = 0; i < len; i++) {
            int digit = x.charAt(i) - '0';
            if (limit < digit) {
                count += (long) Math.pow(limit + 1, len - i);
                return count;
            }
            count += (long) (digit) * (long) Math.pow(limit + 1, len - 1- i);
        }
        if (x.substring(x.length() - s.length()).compareTo(s) >= 0) count++;
        return count;
    }
}
