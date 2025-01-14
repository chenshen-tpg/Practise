package LC_Questions.WholePackage.TwoPointers.LC75;

import java.util.Arrays;
import java.util.HashMap;

public class MaxNumberOfKSUMParis_1679 {
    public static void main(String[] args) {
        MaxNumberOfKSUMParis_1679 mn = new MaxNumberOfKSUMParis_1679();
        System.out.println(mn.maxOperationsTwoPointers(new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4}, 2));
    }

    private int maxOperationsTwoPointers(int[] ints, int i) {
        Arrays.sort(ints);
        int l = 0, r = ints.length - 1;
        int count = 0;
        while (l < r) {
            if (ints[l] + ints[r] == i) {
                l++;
                count++;
                r--;
            } else if (ints[l] + ints[r] < i) {
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
    public int maxOperations_hashmap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = k - nums[i];
            if (map.getOrDefault(current, 0) > 0 & map.getOrDefault(complement, 0) > 0) {
                if ((current == complement) && map.get(current) < 2) continue;
                map.put(current, map.get(current) - 1);
                map.put(complement, map.get(complement) - 1);
                count++;
            }
        }
        return count;
    }
}
