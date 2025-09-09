package CodingQuestions.Algorithms.DP.LongestCommonSubsequence_1143;

import java.util.ArrayList;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch lis = new BinarySearch();
        System.out.println(lis.lengthOfLIS1(new int[]{0,1,0,3,2,3}));
    }

    public int lengthOfLIS1(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }

        return sub.size();
    }
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
