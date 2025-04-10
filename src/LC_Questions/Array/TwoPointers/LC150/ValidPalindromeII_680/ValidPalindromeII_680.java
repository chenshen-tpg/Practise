package LC_Questions.Array.TwoPointers.LC150.ValidPalindromeII_680;

public class ValidPalindromeII_680 {
    public static void main(String[] args) {
        String s = "abca";
        ValidPalindromeII_680 v = new ValidPalindromeII_680();
        v.validPalindrome(s);
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int count = 0;
        while (i < j) {
            if (count == 0 && s.charAt(i) != s.charAt(j)) {
                return (check(s,i,j-1) || check(s,i+1,j));
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean check(String s, int i, int j){
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
