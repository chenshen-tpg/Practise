package LC_Questions.DP.Others.ShortestCommonSequence_1092;

public class Review {
    public String helper (String str1, String str2) {
        String [] prev = new String[str2.length() + 1];
        for (int i = 0; i <= str2.length(); i++) {
            prev[i] = str2.substring(0,i);
        }
        for (int i = 0; i <= str1.length(); i++) {
            String [] cur = new String[str2.length() + 1];
            cur[0] = str1.substring(0, i);
            for (int j = 0; j <= str2.length() ; j++) {
                if (str1.charAt(i - 1) == str2.charAt(i - 2)) {
                    cur[j] = prev[j - 1] + str1.charAt(i - 1);
                } else {
                    cur[j] = (str1.length() < str2.length()) ? prev[j] + str1.charAt(i - 1) : cur[j-1] + str2.charAt(j - 1);
                }
            }
            prev = cur;
        }
        return prev[str2.length()];
    }
}
