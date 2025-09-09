package CodingQuestions.Algorithms.Array.TwoPointers.ValidPalindrome_125;

public class Replace {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(palindrome(s));
    }

    private static boolean palindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                char leftChar = Character.toLowerCase(s.charAt(left));
                char rightChar = Character.toLowerCase(s.charAt(right));
                if (Character.isLetter(s.charAt(left)) && Character.isLetter(s.charAt(right))) {
                    if (leftChar != rightChar) return false;
                } else if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

}
