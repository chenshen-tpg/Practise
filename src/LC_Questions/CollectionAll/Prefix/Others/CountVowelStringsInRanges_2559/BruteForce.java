package LC_Questions.CollectionAll.Prefix.Others.CountVowelStringsInRanges_2559;

public class BruteForce {
    //    String[] words = {"aba", "bcb", "ece", "aa", "e"};
    //    int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
    //    1, 1, 2, 3, 4
    public static void main(String[] args) {
        BruteForce solution = new BruteForce();
        solution.bruteForce(new String [] {"aba", "bcb", "ece", "aa", "e"}, new int [][] {{0, 2}, {1, 4}, {1, 1}});
    }

    public int[] bruteForce(String[] words, int[][] queries) {
        String vowel = "aeiou";
        int [] ans = new int [queries.length];
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int temp = 0;
            while (left <= right) {
                int len = words[left].length();
                if (vowel.contains(words[left].charAt(0)+ "") && vowel.contains(words[left].charAt(len - 1)+ "")) {
                    temp++;
                }
                left++;
            }
            ans[index++] = temp;
        }
        return ans;
    }



}
