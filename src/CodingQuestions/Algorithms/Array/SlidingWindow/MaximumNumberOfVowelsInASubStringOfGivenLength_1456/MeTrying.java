package CodingQuestions.Algorithms.Array.SlidingWindow.MaximumNumberOfVowelsInASubStringOfGivenLength_1456;

public class MeTrying {
    public static void main(String[] args) {

    }
    public int maxVowels(String s, int k) {
        int res = 0;
        char[] c = s.toCharArray();
        int init = 0;
        if (s.isEmpty() || k == 0) {
            return 0;
        }
        if (k > s.length()) {
            k = s.length();
        }
        for (int i = 0; i < k; i++) {
            if ("aeiou".contains(c[i] + "")) {
                init++;
            }
        }
        res = init;
        for (int i = k; i < c.length; i++) {
            if ("aeiou".contains(c[i] + "")) {
                init++;
            }
            if ("aeiou".contains(c[i - k] + "")) {
                init--;
            }
            res = Math.max(res, init);
            if (res == k) {
                return k;
            }
        }
        return res;
    }
}
