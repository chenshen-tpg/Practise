package CodingQuestions.Algorithms.Array.ArrayGeneral.CountHillAndValley_2210;

public class MeTrying {
    public static void main(String[] args) {

    }
    public int countHillValley(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i-1] ) {
                while (i < nums.length - 1 && nums[i+1] == nums[i]) {
                    i++;
                    if (i == nums.length - 1) {
                        break;
                    }
                }
                if (i < nums.length - 1 && nums[i+1] < nums[i]) {
                    count++;
                }
            } else if ( nums[i] < nums[i-1]) {
                while (i < nums.length - 1 && nums[i+1] == nums[i]) {
                    i++;
                    if (i == nums.length - 1) {
                        break;
                    }
                }
                if (i < nums.length - 1 && nums[i+1] > nums[i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
