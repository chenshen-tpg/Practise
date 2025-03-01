package LC_Questions.CollectionAll.SlidingWindow.PremiumAlgo100.LongestSubstringWithAtMostTwoDistinctCharacters_159;

public class SlidingWindowsArray {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] memo = new int[128];
        //Count instead of size in HashMap
        int i = 0, j = 0, res = 0, count = 0;
        while (j < s.length()) {
            if (memo[s.charAt(j)] == 0) count++;
            memo[s.charAt(j)]++;
            j++;
            while (count > 2) {
                //Instead of collection to find the min, we just keep removing the first character we found.
                memo[s.charAt(i)]--;
                if (memo[s.charAt(i)] == 0) count--;
                i++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
