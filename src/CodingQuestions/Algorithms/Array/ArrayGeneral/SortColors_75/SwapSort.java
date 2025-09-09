package CodingQuestions.Algorithms.Array.ArrayGeneral.SortColors_75;

public class SwapSort {
    public static void main(String[] args) {
        SwapSort solution = new SwapSort();
        int [] test = new int [] {2,0,2,1,1,1};
        solution.sortColors(test);
        for (int i = 0; i < test.length; i++) {
            if (i == test.length - 1) System.out.println(test[i]);
            System.out.print(test[i] + ",");
        }
    }
    public void switchThem(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void sortColors(int[] nums) {
        int left = 0;
        int zeroes = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == 0) {
                switchThem(nums, left, zeroes);
                left++;
                zeroes++;
            } else if (nums[left] == 2) {
                switchThem(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
    }
}
