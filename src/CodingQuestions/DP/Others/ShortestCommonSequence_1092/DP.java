package CodingQuestions.DP.Others.ShortestCommonSequence_1092;

public class DP {

    public static void main(String[] args) {
        DP solution = new DP();
        solution.shortestCommonSupersequence("abca", "cab");
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        String[] prev = new String[str2.length() + 1];
        for (int i = 0; i <= str2.length(); i++) prev[i] = str2.substring(0, i);
        for (int i = 1; i <= str1.length(); i++) {
            String[] cur = new String[str2.length() + 1];
            cur[0] = str1.substring(0, i);
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) cur[j] = prev[j - 1] + str1.charAt(i - 1);
                else {
                    String s1 = prev[j];
                    String s2 = cur[j - 1];
                    cur[j] = (s1.length() < s2.length()) ? s1 + str1.charAt(i - 1): s2 + str2.charAt(j - 1);
                }
            }
            prev = cur;
        }
        return prev[str2.length()];
    }
}
