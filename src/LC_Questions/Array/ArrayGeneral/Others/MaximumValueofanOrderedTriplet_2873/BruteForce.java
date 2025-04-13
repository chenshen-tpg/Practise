package LC_Questions.Array.ArrayGeneral.Others.MaximumValueofanOrderedTriplet_2873;

public class BruteForce {
    public static void main(String[] args) {
        maximumTripletValue(new int [] {1000000,1,1000000});
    }
    public static long maximumTripletValue(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if (i != j && i != k && j != k) {
                        ans = Math.max(ans, (long)(nums[i] - nums[j]) * nums[k]);
                    }
                }
            }
        }
        return ans;
    }
}
