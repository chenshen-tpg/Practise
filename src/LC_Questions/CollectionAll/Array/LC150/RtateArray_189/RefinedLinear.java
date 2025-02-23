package LC_Questions.CollectionAll.Array.LC150.RtateArray_189;

public class RefinedLinear {
    public static void main(String[] args) {
        RefinedLinear solution = new RefinedLinear();
        solution.rotate(new int [] {1,2,3,4,5,6,7}, 3);
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            //impressive..
            a[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = a[i];
        }
    }
}
