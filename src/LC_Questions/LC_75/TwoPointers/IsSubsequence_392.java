package LC_Questions.LC_75.TwoPointers;

public class IsSubsequence_392 {
    public static void main(String[] args) {
        IsSubsequence_392 is = new IsSubsequence_392();
        System.out.println(is.isSubsequence("abc", "ahbgdc"));
    }

    private boolean isSubsequence(String abc, String ahbgdc) {
        for (char ss:abc.toCharArray()) {
            if (!abc.contains(ss+"")) {
                return false;
            }
        }
        return true;
    }
}
