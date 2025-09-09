package CodingQuestions.Algorithms.Array.Prefix.CountVowelStringsInRanges_2559;

public class HalfPrefix {
    public static void main(String[] args) {
        HalfPrefix solution = new HalfPrefix();
        int ans [] = solution.halfPrefix(new String [] {"aba", "bcb", "ece", "aa", "e"}, new int [][] {{0, 2}, {1, 4}, {1, 1}});
        for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
    }
    public int[] halfPrefix (String[] words, int [][] queries) {
        String vowel = "aeiou";
        int [] countAll = new int [words.length];
        int [] ans = new int [queries.length];
        for (int i = 0; i < words.length; i++) {
            if (vowel.contains(words[i].charAt(0)+ "") && vowel.contains(words[i].charAt(words[i].length() - 1)+ "")) {
                countAll[i] = 1;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                count += countAll[j];
            }
            ans[i] = count;
        }
        return ans;
    }
}
