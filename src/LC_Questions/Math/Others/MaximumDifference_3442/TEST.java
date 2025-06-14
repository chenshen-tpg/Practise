package LC_Questions.Math.Others.MaximumDifference_3442;

public class TEST {
    public static void main(String[] args) {
        maxDifference("aaaaabbc");
    }
    public static int maxDifference(String s) {
        int [] memo = new int [26];
        for (char temp : s.toCharArray()) {
            memo[temp - 'a']++;
        }
        int odd = 0, even = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (memo[i] == 0 && memo[i] < even) {
                even = memo[i];
            }
            else if (memo[i] % 2 == 1 && memo[i] > odd) {
                odd = memo[i];
            }
        }
        return odd - even;
    }
}
