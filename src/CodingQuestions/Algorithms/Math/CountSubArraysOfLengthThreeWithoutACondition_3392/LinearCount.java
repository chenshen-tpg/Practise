package CodingQuestions.Algorithms.Math.CountSubArraysOfLengthThreeWithoutACondition_3392;

public class LinearCount {

    public static void main(String[] args) {
        System.out.println(helper(new int [] {1, 2, 1, 4, 1}));
    }

    public static int[] helper(int[] arr) {
        int[] ans = new int[3];
        for (int i = 0; i < arr.length - 2; i++) {
            if (2 * (arr[i] + arr[i + 2]) == arr[i + 1]) {
                ans = new int[]{arr[i], arr[i + 1], i + 2};
            }
        }
        return ans;
    }
}
