package LC_Questions.DailyChanllenges.FindThePrefixCommonArrayOfTwoArrays_2657;

public class Trying {
    public static void main(String[] args) {
        int [] a = {1,3,2,4};
        int [] b = {3,1,2,4};
        System.out.println(method(a,b));
    }

    public static int[] method(int [] a, int [] b) {
        int [] prefix = new int [a.length];
        int [] memo = new int [a.length+1];
        int common = 0;
        for (int i = 0; i < a.length; i++) {
            // If a[i] and b[i] are the same, common will only be incremented once if memo[a[i]] reaches 2
            memo[a[i]]++;
            if (memo[a[i]] == 2) common++;
            memo[b[i]]++;
            if (memo[b[i]] == 2) common++;
            prefix[i] = common;
        }
        return prefix;
    }
}
