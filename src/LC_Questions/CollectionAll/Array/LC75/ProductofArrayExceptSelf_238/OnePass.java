package LC_Questions.CollectionAll.Array.LC75.ProductofArrayExceptSelf_238;

public class OnePass {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        productExceptSelf(nums);
    }
    public static int[] productExceptSelf(int[] nums) {
        int [] res = new int [nums.length];
        int total = 1;
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) countZero++;
            else total *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (countZero == 1) {
                if (nums[i] == 0) {
                    res[i] = total;
                }
                else {
                    res[i] = 0;
                }
            }
            else if (countZero > 1) {
                res[i] = 0;
            } else {
                res[i] = total / nums[i];
            }
        }
        return res;
    }
}
