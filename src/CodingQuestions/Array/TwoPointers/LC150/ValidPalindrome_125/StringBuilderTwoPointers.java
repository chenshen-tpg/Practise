package CodingQuestions.Array.TwoPointers.LC150.ValidPalindrome_125;

public class StringBuilderTwoPointers {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 0 || s.length() == 1) return true;
        for (char ss : s.toCharArray()) {
            if (Character.isAlphabetic(ss) || Character.isDigit(ss)) {
                sb.append(Character.toLowerCase(ss));
            }
        }
        return helper(sb.toString());
    }
    public static boolean helper(String s){
        for (int i = 0; i < s.length() / 2 ; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
