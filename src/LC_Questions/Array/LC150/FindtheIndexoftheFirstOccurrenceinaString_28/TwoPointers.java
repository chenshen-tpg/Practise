package LC_Questions.Array.LC150.FindtheIndexoftheFirstOccurrenceinaString_28;

public class TwoPointers {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issip";
        System.out.println(twoPointers(haystack, needle));
    }

    public static int twoPointers (String s1, String s2) {
        if (s2.isEmpty()) return 0;
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            int j = 0;
            while (j < s2.length() && i + j < s1.length() && s1.charAt(i + j) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) return i;
        }
        return -1;
    }
}
