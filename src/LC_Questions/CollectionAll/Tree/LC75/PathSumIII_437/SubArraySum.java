package LC_Questions.CollectionAll.Tree.LC75.PathSumIII_437;

import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
        int [] test = {1,2,3,4,7,6,1,1,2};
        SubArraySum s = new SubArraySum();
        System.out.println(s.subarraySum(test,7));
    }
    public int subarraySum(int[] nums, int k) {
        int count = 0, currSum = 0;
        HashMap<Integer, Integer> h = new HashMap();
        for (int num : nums) {
            currSum += num;
            if (currSum == k) count++;
            count += h.getOrDefault(currSum - k, 0);
            h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
