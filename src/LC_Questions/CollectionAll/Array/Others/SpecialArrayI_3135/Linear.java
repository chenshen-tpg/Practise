package LC_Questions.CollectionAll.Array.Others.SpecialArrayI_3135;

public class Linear {
    public static void main(String[] args) {
        int [] arr = {4,3,1,6};
        Linear solution = new Linear();
        System.out.println(solution.isArraySpecial(arr));
    }



    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;
        for (int i = 1; i < nums.length; i++) {
            boolean even = false;
            boolean odd = false;
            if (nums[i-1] % 2 == 0) {
                even = true;
            } else {
                odd = true;
            }
            if (nums[i] % 2 == 0) {
                even = true;
            } else {
                odd = true;
            }
            if (!even || !odd) return false;
        }
        return true;
    }
}
