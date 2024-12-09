package LC_Questions.LC_75.PrefixSum;

public class FindPivotIndex_724 {
    public static void main(String[] args) {
        FindPivotIndex_724 f = new FindPivotIndex_724();
        System.out.println(f.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        
    }

    private int pivotIndex(int[] nums) {
        int left = 0, sum =0;
        for (int num:nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {

            if (left == sum - nums[i] - left) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
