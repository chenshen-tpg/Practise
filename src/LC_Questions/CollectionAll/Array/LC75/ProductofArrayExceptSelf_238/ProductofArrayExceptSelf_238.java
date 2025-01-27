package LC_Questions.CollectionAll.Array.LC75.ProductofArrayExceptSelf_238;

public class ProductofArrayExceptSelf_238 {
    public static void main(String[] args) {
        ProductofArrayExceptSelf_238 p = new ProductofArrayExceptSelf_238();
        int[] nums = new int[]{1,2,3,4};
        int[] res = p.productExceptSelf(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }
}
