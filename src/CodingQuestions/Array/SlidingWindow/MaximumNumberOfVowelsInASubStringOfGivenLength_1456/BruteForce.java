package CodingQuestions.Array.SlidingWindow.MaximumNumberOfVowelsInASubStringOfGivenLength_1456;

public class BruteForce {
    public static void main(String[] args) {

    }
    public int maxVowels(String s, int k) {
        int res = 0;
        char [] c  = s.toCharArray();
        for (int i = 0; i <= c.length - k; i++) {
            int temp = 0;
            for (int j = i; j < i + k; j++) {
                if ("aeiou".contains(c[j]+ "")) {
                    temp++;
                }
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
