package CodingQuestions.Array.TwoPointers.Others.MovePiecesToObtainString_2337;

public class TwoPointers {
    public static void main(String[] args) {

    }
    public boolean canChange(String start, String target) {
        int len = start.length();
        int i = 0, j = 0;
        while (i < len || j < len) {
            while (i < len && start.charAt(i) == '_') i++;
            while (j < len && target.charAt(j) == '_') j++;
            if (i == len || j == len) return i == len && j == len;
            if (start.charAt(i) != target.charAt(j) || (start.charAt(i) == 'L' && i < j)
                    || (start.charAt(i) == 'R' && i > j)) return false;
            i++;
            j++;
        }
        return true;
    }
}
