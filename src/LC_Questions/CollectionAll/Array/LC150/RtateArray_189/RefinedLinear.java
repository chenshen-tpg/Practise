package LC_Questions.CollectionAll.Array.LC150.RtateArray_189;

public class RefinedLinear {
    public static void main(String[] args) {

    }
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //impressive..
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
