package CodingQuestions.Algorithms.Array.SlidingWindow.FindKLengthSubSringsWithNoRepeated_1100;

public class ArraySliding {
    public static void main(String[] args) {

    }

    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > 26) return 0;
        int i = 0, j = 0, len = s.length(), count = 0;
        int[] memo = new int[26];
        while (i < len) {
            memo[s.charAt(i) - 'a']++;
            while (memo[s.charAt(i) - 'a'] > 1) {
                memo[s.charAt(j) - 'a']--;
                j++;
            }
            if (i - j + 1 == k) {
                count++;
                memo[s.charAt(j) - 'a']--;

                j++;
            }
            i++;
        }
        return count;
    }
}
