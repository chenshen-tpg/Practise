package LC_Questions.Array.Hash.LC150.ContainsDuplicateII_219;

import java.util.HashMap;

public class ContainsDuplicateII_219 {
    public static void main(String[] args) {
        ContainsDuplicateII_219 cd = new ContainsDuplicateII_219();
        int[] nums = {1,0,1,1};
        int k = 1;
        System.out.println(cd.containsNearbyDuplicate(nums, k));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                if (i - hm.get(nums[i]) <= k) {
                    return true;
                }
                hm.put(nums[i], i);
            }
            hm.put(nums[i], i);
        }
        return false;
    }
}
