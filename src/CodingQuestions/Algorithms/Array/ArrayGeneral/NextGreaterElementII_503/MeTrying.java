package CodingQuestions.Algorithms.Array.ArrayGeneral.NextGreaterElementII_503;

public class MeTrying {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElements(int[] nums) {
        int [] res = new int [nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean found = false;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    found = true;
                    res[index] = nums[j];
                    index++;
                    break;
                }
            }
            if (!found) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        found = true;
                        res[index] = nums[j];
                        index++;
                        break;
                    }
                }
            }
            if (!found) {
                res[index] = -1;
                index++;
            }
        }
        return res;
    }
}
