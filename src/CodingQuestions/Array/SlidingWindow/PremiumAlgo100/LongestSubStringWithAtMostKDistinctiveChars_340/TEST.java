package CodingQuestions.Array.SlidingWindow.PremiumAlgo100.LongestSubStringWithAtMostKDistinctiveChars_340;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.helper("eceba", 2);

    }

    public  int helper (String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            //could expand
//            if (count[s.charAt(j)] == 0) {
//                num++;
//            }
//            count[s.charAt(j)]++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
