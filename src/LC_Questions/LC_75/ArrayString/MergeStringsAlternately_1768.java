package LC_Questions.LC_75.ArrayString;

public class MergeStringsAlternately_1768 {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        MergeStringsAlternately_1768 m = new MergeStringsAlternately_1768();
        System.out.println(m.mergeAlternately(word1, word2));
    }

    private String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if (i < word1.length()) {
            sb.append(word1.substring(i));
        }
        if (i < word2.length()) {
            sb.append(word2.substring(i));
        }
        return sb.toString();
    }
    public String mergeAlternately1(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while(i<len1 || j < len2) {
            if (i<len1) {
                result.append(word1.charAt(i++));
            }
            if (j<len2) {
                result.append(word2.charAt(j++));
            }
        }
        return result.toString();
    }
}
