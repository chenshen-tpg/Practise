package LC_Questions.WholePackage.Queue.LC100.SlidingWindowMaximum_329;

import java.util.LinkedList;

public class MeTrying {
    public static void main(String[] args) {
//        int [] num = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int [] num = {1,-1};
        helper(num, 1);
    }

    public static int [] helper (int [] nums, int k) {
        int index = 0;
        int [] res = new int [nums.length - k + 1];
        LinkedList<Integer> li = new LinkedList<>();
        int tempMax = 0;
        for (int i = 0; i < k; i++) {
            li.add(nums[i]);
        }

        return res;
    }

    // not working when the next one is smaller and needs to be selected
    public static int [] InitialThought (int [] nums, int k) {
        int index = 0;
        int [] res = new int [nums.length - k + 1];
//        LinkedList<Integer> li = new LinkedList<>();
        int tempMax = 0;
        for (int i = 0; i < k; i++) {
//            li.add(nums[i]);
            if (nums[i] > tempMax) {
                tempMax = nums[i];
            }
        }
        for (int i = k - 1; i < nums.length; i++) {
            if (nums[i] > tempMax) {
                tempMax = nums[i];
                res[index++] = tempMax;
            }
            else {
                res[index++]  = tempMax;
            }
        }
        return res;
    }
}
