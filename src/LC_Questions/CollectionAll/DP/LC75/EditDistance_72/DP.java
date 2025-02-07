package LC_Questions.CollectionAll.DP.LC75.EditDistance_72;

public class DP {
        Integer memo[][];

        public static void main(String[] args) {

        }
        public int minDistance(String word1, String word2) {
            memo = new Integer[word1.length() + 1][word2.length() + 1];
            return minDistanceRecur(word1, word2, word1.length(), word2.length());
        }

        int minDistanceRecur(String w1, String w2, int w1index, int w2index) {
            if (w1index == 0) return w2index;
            if (w2index == 0) return w1index;
            if (memo[w1index][w2index] != null) return memo[w1index][w2index];
            int ans = 0;
            if (w1.charAt(w1index - 1) == w2.charAt(w2index - 1)) ans = minDistanceRecur(w1, w2, w1index - 1, w2index - 1);
            else {
                int insertOperation = minDistanceRecur(w1, w2, w1index, w2index - 1);
                int deleteOperation = minDistanceRecur(w1, w2, w1index - 1, w2index);
                int replaceOperation = minDistanceRecur(w1, w2, w1index - 1, w2index - 1);
                ans = Math.min(insertOperation, Math.min(deleteOperation, replaceOperation)) + 1;
            }
            memo[w1index][w2index] = ans;
            return ans;
        }

}
