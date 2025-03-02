package LC_Questions.TwoPointers.LC75.IsSubsequence_392;

public class BuiltIn {
    public static void main(String[] args) {

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
