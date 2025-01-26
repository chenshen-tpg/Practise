package LC_Questions.WholePackage.Array.Others;

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(method2(s));
    }
    public static boolean method2 (String s) {
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
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }
}
