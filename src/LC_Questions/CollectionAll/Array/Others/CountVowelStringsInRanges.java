package LC_Questions.CollectionAll.Array.Others;

public class CountVowelStringsInRanges {
    public static void main(String[] args) {
        CountVowelStringsInRanges solution = new CountVowelStringsInRanges();
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        solution.vowelStrings(words,queries);
    }
    public int[] vowelStrings_TEL(String[] words, int[][] queries) {
        String vowel = "aeiou";
        int [] ans = new int [queries.length];
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int temp = 0;
            while (left <= right) {
                int len = words[left].length();
                if (vowel.contains(words[left].charAt(0)+"") && vowel.contains(words[left].charAt(len-1)+"")) {
                    temp++;
                }
                left++;
            }
            ans[index++] = temp;
        }
        return ans;
    }
//    String[] words = {"aba", "bcb", "ece", "aa", "e"};
//    int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
//    1, 1, 2, 3, 4
    public int[] vowelStrings(String[]words, int[][] queries) {
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
