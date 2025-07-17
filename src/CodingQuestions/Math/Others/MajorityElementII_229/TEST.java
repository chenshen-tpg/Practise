package CodingQuestions.Math.Others.MajorityElementII_229;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.majorityElement(new int [] {3,2,3});
    }

    public List< Integer > majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;
        for (int n: nums) {
            if (candidate1 != null && candidate1 == n) count1++;
            else if (candidate2 != null && candidate2 == n) count2++;
            else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int n: nums) {
            if (candidate1 != null && n == candidate1) count1++;
            if (candidate2 != null && n == candidate2) count2++;
        }
        int n = nums.length;
        if (count1 > n/3) result.add(candidate1);
        if (count2 > n/3) result.add(candidate2);
        return result;
    }
}
