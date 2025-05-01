package LC_Questions.LinkedList.Others.MaximumPoints_1423;

public class TEST {
    public static void main(String[] args) {
        int [] point = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        maxScore(point, k);
    }
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] frontSetOfCards = new int[k + 1];
        int[] rearSetOfCards = new int[k + 1];
        for (int i = 0; i < k; i++) {
            frontSetOfCards[i + 1] = cardPoints[i] + frontSetOfCards[i];
            rearSetOfCards[i + 1] = cardPoints[n - i - 1] + rearSetOfCards[i];
        }

        int maxScore = 0;
        for (int i = 0; i <= k; i++) {
            int currentScore = frontSetOfCards[i] + rearSetOfCards[k - i];
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}
