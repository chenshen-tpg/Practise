package LC_Questions.CollectionAll.Stack.LC75.RemovingStarFromAString_2390;

public class TwoPointers {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(method(s));
    }

    private static String method(String s) {
        char memo [] = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            //take back the rare one.
            if (s.charAt(i) == '*') j--;
            else {
                memo[j++] = s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < j; i++) {
            sb.append(memo[i]);
        }
        return sb.toString();
    }
}
