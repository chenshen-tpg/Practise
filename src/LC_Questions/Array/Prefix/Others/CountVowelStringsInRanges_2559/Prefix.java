package LC_Questions.Array.Prefix.Others.CountVowelStringsInRanges_2559;

public class Prefix {

    //    String[] words = {"aba", "bcb", "ece", "aa", "e"};
    //    int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
    //    1, 1, 2, 3, 4
    public static void main(String[] args) {
        Prefix solution = new Prefix();
        int ans [] = solution.prefixSolution(new String [] {"aba", "bcb", "ece", "aa", "e"}, new int [][] {{0, 2}, {1, 4}, {1, 1}});
        for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");

    }


    public int[] prefixSolution(String[]words, int[][] queries) {
        int [] ans = new int[queries.length];
        String vowel = "aeiou";
        int [] wordCount = new int[words.length];
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            if (vowel.contains(words[i].charAt(0) + "") && vowel.contains(words[i].charAt(len - 1) + "")) sum++;
            wordCount[i] = sum;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] cur = queries[i];
            if (cur[0] == 0) ans[i] = wordCount[cur[1]];
            else
                ans[i] = wordCount[cur[1]] - wordCount[cur[0] - 1];
        }
        return ans;
    }
}
