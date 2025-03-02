package LC_Questions.Prefix.Others.CountVowelStringsInRanges_2559;

public class Review {
    public static void main(String[] args) {
        Review solution = new Review();
        int ans [] = solution.helper(new String [] {"aba", "bcb", "ece", "aa", "e"}, new int [][] {{0, 2}, {1, 4}, {1, 1}});
        for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
    }

    public static int [] helper (String [] arr, int [][] query) {
        String vowel = "aeiou";
        int [] ans = new int [query.length];
        int [] prefix = new int [arr.length];
        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
//            this is an equivalent
//            if (vowel.contains(arr[i].charAt(0) + "") && vowel.contains(arr[i].charAt(arr[i].length() - 1) + "")) {
//                prefix[i] = ++pre;
//            } else {
//                prefix[i] = pre;
//            }
            if (vowel.contains(arr[i].charAt(0) + "") && vowel.contains(arr[i].charAt(arr[i].length() - 1) + "")) pre++;
            prefix[i] = pre;
        }
        for (int i = 0; i < query.length; i++) {
            if (query[i][0] == 0) ans[i] = prefix[query[i][1]];
            else ans[i] = prefix[query[i][1]] - prefix[query[i][0] - 1];
        }
        return ans;
    }
}
