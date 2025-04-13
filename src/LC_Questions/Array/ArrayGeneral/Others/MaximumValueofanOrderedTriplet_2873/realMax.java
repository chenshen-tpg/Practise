package LC_Questions.Array.ArrayGeneral.Others.MaximumValueofanOrderedTriplet_2873;

public class realMax {
    public static void main(String[] args) {

    }
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0, i = 0, ij = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, ij * nums[k]);
            ij = Math.max(ij, i - nums[k]);
            i = Math.max(i, nums[k]);
        }
        return res;
    }
}
