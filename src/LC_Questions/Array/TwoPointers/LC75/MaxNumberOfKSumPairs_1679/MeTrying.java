package LC_Questions.Array.TwoPointers.LC75.MaxNumberOfKSumPairs_1679;

import java.util.Arrays;
import java.util.HashMap;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying mn = new MeTrying();
        System.out.println(mn.hashmap(new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4}, 2));
    }

    private int helper(int[] ints, int k) {
        Arrays.sort(ints);
        int ans = 0;
        int l = 0, r = ints.length - 1;
        while (l < r) {
            if (ints[l] + ints[r] == k) {
                ans++;
                l++;
                r--;
            }
            if (ints[l] + ints[r] < k) l++;
            else r--;
        }
        return ans;
    }

    public int hashmap(int [] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = k - current;
            if (hm.getOrDefault(complement, 0) > 0) {
                hm.put(complement, hm.get(complement) - 1);
                ans++;
            } else {
                hm.put(current, hm.getOrDefault(current, 0) + 1);
            }
        }
        return ans;
    }
}
