package Learning.General.LeeCodeStyleQ.SlidingWindow.MaximumPointsYouCanObtainFromCards_1423;

public class TEST {
    public static void main(String[] args) {

    }
    public int maxScore(int[] cardPoints, int k) {
        int [] memo1 = new int [k + 1], memo2 = new int [k + 1];
        for (int i = 0; i < k; i ++) {
            memo1[i + 1] = memo1[i] + cardPoints[i];
            memo2[i + 1] = memo2[i] + cardPoints[cardPoints.length - i -1];
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, memo1[i] + memo2[k - i]);
        }
        return ans;
    }
}
