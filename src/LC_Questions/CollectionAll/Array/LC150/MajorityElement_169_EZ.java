package LC_Questions.CollectionAll.Array.LC150;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement_169_EZ {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        if (nums.length <= 2) {
            return nums[0];
        }
        for (Integer num:nums) {
            hm.put(num, hm.getOrDefault(num,0) + 1);
            if (hm.containsKey(num) && hm.get(num) > nums.length / 2){
                return num;
            }
        }
        return 0;
    }
    public int majorityElement_wtf(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public int majorityElementBitVersion(int[] nums) {
        int n = nums.length;
        int majority_element = 0;

        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;

            // Count how many numbers have this bit set.
            int bit_count = 0;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    bit_count++;
                }
            }
            // If this bit is present in more than n / 2 elements
            // then it must be set in the majority element.
            if (bit_count > n / 2) {
                majority_element |= bit;
            }
        }

        return majority_element;
    }
}
