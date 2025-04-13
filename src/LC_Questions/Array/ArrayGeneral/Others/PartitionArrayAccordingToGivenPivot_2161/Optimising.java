package LC_Questions.Array.ArrayGeneral.Others.PartitionArrayAccordingToGivenPivot_2161;

public class Optimising {
    public static void main(String[] args) {
        pivotArray(new int [] {9,12,5,10,14,3,10}, 10);
    }
    public static int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                ans[left] = nums[i];
                left++;
            }
            if (nums[j] > pivot) {
                ans[right] = nums[j];
                right--;
            }
        }
        while (left <= right) {
            ans[left] = pivot;
            left++;
        }
        return ans;
    }
}
