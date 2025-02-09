package LC_Questions.CollectionAll.Array.Others.DistinctNumbersInEachSubArray_1852;

import java.util.HashSet;

public class BruteForce_TLE {


    public static void main(String[] args) {
        int [] nums = {1,2,3,2,2,1,3};
        int k = 3;
        int [] res = helper(nums,k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int [] helper (int [] nums, int k) {
        int [] res = new int [nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            HashSet<Integer> temp = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                temp.add(nums[j]);
            }
            res[i] = temp.size();
        }
        return res;
    }
}
