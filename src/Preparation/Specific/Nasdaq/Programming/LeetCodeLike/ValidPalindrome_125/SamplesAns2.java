package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.ValidPalindrome_125;

public class SamplesAns2 {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (Character.isLetterOrDigit(cur)) sb.append(Character.toLowerCase(cur));
        }
        String forward = sb.toString();
        String backward = sb.reverse().toString();
        return forward.equals(backward);
    }
}
