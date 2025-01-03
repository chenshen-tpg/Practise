package LC_Questions.WholePackage.PrefixSum;

public class FindTheHiestAltitude_1732 {
    public static void main(String[] args) {
        int[] gain = new int[]{-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }

    private static int largestAltitude(int[] gain) {
        int [] memo = new int [gain.length];
        int tem = 0;
        int ans = 0;
        for(int i = 0; i < gain.length; i++) {
            tem += gain[i];
            memo[i] = tem;
            ans = Math.max(ans, memo[i]);
        }
        return ans;
    }
    public int largestAltitudeModel(int[] gain) {
        int currentAltitude = 0;
        int highestPoint = currentAltitude;
        for (int altitudeGain : gain) {
            currentAltitude += altitudeGain;
            highestPoint = Math.max(highestPoint, currentAltitude);
        }
        return highestPoint;
    }
}
