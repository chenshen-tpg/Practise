package CodingQuestions.Algorithms.Array.TwoPointers.IsSubsequence_392;

public class SampleAns {
    public static void main(String[] args) {

    }
    public boolean isSubsequence(String s, String t) {
        char[] sub = s.toCharArray();
        char[] tar = t.toCharArray();
        int m = sub.length;
        int n = tar.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (sub[i] == tar[j]) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}
