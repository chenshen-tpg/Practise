package LC_Questions.Array.Others.PartitionArrayAccordingToGivenPivot;

public class ThreePass {
    public static void main(String[] args) {
        pivotArray (new int [] {9,5,3,10,10,12,14}, 10);
    }
    public static int[] pivotArray(int[] nums, int pivot) {
        int [] res = new int [nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) res[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) res[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) res[index++] = nums[i];
        }
        return res;
    }
}
