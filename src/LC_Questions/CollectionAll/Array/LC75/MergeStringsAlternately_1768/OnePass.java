package LC_Questions.CollectionAll.Array.LC75.MergeStringsAlternately_1768;

public class OnePass {
    public static void main(String[] args) {
        String word1 = "ab", word2 = "pqrs";

        System.out.println(helper(word1, word2));
    }
    public static String helper (String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int indexS1 = 0, indexS2 = 0, lenS1 = s1.length(), lenS2 = s2.length();
        while (indexS1 < lenS1 && indexS2 < lenS2) {
            sb.append(s1.charAt(indexS1));
            sb.append(s2.charAt(indexS2));
            indexS1++;
            indexS2++;
        }
        while (indexS1 < lenS1 ) {
            sb.append(s1.charAt(indexS1));
            indexS1++;
        }
        while (indexS2 < lenS2 ) {
            sb.append(s2.charAt(indexS2));
            indexS2++;
        }
        return sb.toString();
    }
}
