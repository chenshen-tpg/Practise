package LC_Questions.Array.BitManipulation.Ohters;

public class BitwiseOrOfAdjacentElements_3173 {
    public static void main(String[] args) {
        int [] nums = {1,3,7,15};
        int [] ans = new int [nums.length-1];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            ans[index++] = nums[i] | nums[i-1];
        }
        System.out.println("done");
    }
}
