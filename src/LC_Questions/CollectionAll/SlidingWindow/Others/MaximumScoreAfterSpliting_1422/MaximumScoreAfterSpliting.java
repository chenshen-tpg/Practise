package LC_Questions.CollectionAll.SlidingWindow.Others.MaximumScoreAfterSpliting_1422;

public class MaximumScoreAfterSpliting {
    public static int max = 0;
    public static void main(String[] args) {
        String s = "1111";

        System.out.println(max);
    }
    public static void helper_myVersion (String s, int i, int max) {
        int count = 0;
        if (i >= s.length()) {return;}
        String left = s.substring(0,i);
        for (int j = 0; j < left.length(); j++) {
            if (left.charAt(j) == '0') {
                count++;
            }
        }
        String right = s.substring(i,s.length());
        for (int k = 0; k < right.length(); k++) {
            if (right.charAt(k) == '1') {
                count++;
            }
        }
        max = Math.max(max, count);
        helper(s,i+1);
    }
    public static void helper(String s, int i) {
        if (i >= s.length()) {
            return;
        }
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (j < i && s.charAt(j) == '0') {
                count++;
            } else if (j >= i && s.charAt(j) == '1') {
                count++;
            }
        }
        max = Math.max(max, count);
        helper(s, i + 1);
    }

}
