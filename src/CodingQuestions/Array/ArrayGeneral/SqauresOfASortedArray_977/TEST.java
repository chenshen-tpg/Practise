package CodingQuestions.Array.ArrayGeneral.SqauresOfASortedArray_977;

public class TEST {
    public static void main(String[] args) {

    }
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int [] res = new int [n];
        int left = 0, right = n - 1, index = n - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[index--] = nums[right] * nums[right];
                right--;
            } else if (Math.abs(nums[left]) > Math.abs(nums[right])){
                res[index--] = nums[left] * nums[left];
                left++;
            } else {
                res[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }
}
