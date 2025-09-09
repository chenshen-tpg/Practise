package CodingQuestions.Algorithms.Array.ArrayGeneral.ProductofArrayExceptSelf_238;

public class MeTrying {
    public static void main(String[] args) {

    }
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                flag = true;
                count++;
            }
            if (nums[i] != 0) {
                mul *= nums[i];
            }
        }
        int [] res = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (flag) {
                if (nums[i] != 0) {
                    res[i] = 0;
                } else {
                    res[i] = mul;
                    if (count >= 2) {
                        res[i] = 0;
                    }
                }
            } else {
                res[i] = mul / nums[i];
            }
        }
        return res;
    }
}
