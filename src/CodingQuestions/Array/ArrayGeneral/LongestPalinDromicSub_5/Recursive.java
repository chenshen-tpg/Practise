package CodingQuestions.Array.ArrayGeneral.LongestPalinDromicSub_5;

public class Recursive {
    public static void main(String[] args) {

    }

    private int maxStart = 0;
    private int maxEnd = 0;

    public String longestPalindrome(String s) {
        expandCenters(s.toCharArray(), 0);
        return s.substring(maxStart, maxEnd + 1);
    }

    private void expandCenters(char[] str, int index) {
        int len = str.length;
        if (index >= len) return;
        int left = index;
        int right = index;
        while (right + 1 < len && str[right] == str[right + 1]) {
            right++;
        }

        int next = right + 1;
        while (left > 0 && right < len - 1 && str[left - 1] == str[right + 1]) {
            left--;
            right++;
        }

        if (right - left > maxEnd - maxStart) {
            maxEnd = right;
            maxStart = left;
        }
        expandCenters(str, next);
    }
}
