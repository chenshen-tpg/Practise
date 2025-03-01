package LC_Questions.CollectionAll.DP.Others.ShortestCommonSequence_1092;

public class DP {

    public static void main(String[] args) {
        DP solution = new DP();
        solution.shortestCommonSupersequence("abca", "cab");
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int len2 = str2.length();
        String[] prev = new String[len2 + 1];
        for (int i = 0; i <= len2; i++) prev[i] = str2.substring(0, i);
        for (int i = 1; i <=  str1.length(); i++) {
            String[] cur = new String[len2 + 1];
            cur[0] = str1.substring(0, i);
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) cur[j] = prev[j - 1] + str1.charAt(i - 1);
                else {
                    String s1 = prev[j];
                    String s2 = cur[j - 1];
                    cur[j] = (s1.length() < s2.length()) ? s1 + str1.charAt(i - 1): s2 + str2.charAt(j - 1);
                }
            }
            prev = cur;
        }
        return prev[len2];
    }
}
