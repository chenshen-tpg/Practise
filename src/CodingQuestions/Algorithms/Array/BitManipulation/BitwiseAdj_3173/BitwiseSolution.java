package CodingQuestions.Algorithms.Array.BitManipulation.BitwiseAdj_3173;

public class BitwiseSolution {
    /***
     Given an array nums of length n, return an array answer of length n - 1
     such that answer[i] = nums[i] | nums[i + 1] where | is the bitwise OR operation.
     */
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
