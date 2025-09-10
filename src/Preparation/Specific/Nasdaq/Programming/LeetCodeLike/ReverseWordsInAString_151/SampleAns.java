package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.ReverseWordsInAString_151;

public class SampleAns {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int startindex = n - 1;
        while (startindex >= 0) {
            while (startindex >= 0 && s.charAt(startindex) == ' ') {
                startindex--;
            }
            if (startindex < 0) {
                break;
            }
            int endindex = startindex;

            while (startindex >= 0 && s.charAt(startindex) != ' ') {
                startindex--;
            }
            if (res.length() == 0) {
                res.append(s.substring(startindex + 1, endindex + 1));
            } else {
                res.append(" ");
                res.append(s.substring(startindex + 1, endindex + 1));
            }
        }
        return res.toString();
    }
}
