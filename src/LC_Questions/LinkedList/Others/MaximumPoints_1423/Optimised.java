package LC_Questions.LinkedList.Others.MaximumPoints_1423;

public class Optimised {
    public static void main(String[] args) {

    }
    public int maxScore(int[] cardPoints, int k) {
        int front = 0, back = 0;
        for (int i = 0; i < k; i++) front += cardPoints[i];
        int maxScore = front;
        for (int i = k - 1; i >= 0; i--) {
            back += cardPoints[cardPoints.length - (k - i)];
            front -= cardPoints[i];
            maxScore = Math.max(maxScore, back + front);
        }
        return maxScore;
    }
}
