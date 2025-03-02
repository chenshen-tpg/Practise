package LC_Questions.Array.Others;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumNumberofOperationstoMakeElementsInArrayDistinct_3396 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 2, 3, 3, 5, 7};
        System.out.println(method(nums1));
    }

    public static int method(int [] nums) {
        int[] freq = new int[101];
        Arrays.fill(freq, 0);
        for(int i = nums.length-1; i >= 0; --i){
            if (++freq[nums[i]] > 1) {
                return (int)Math.ceil((double)(i + 1)/3);
            }
        }
        return 0;
    }
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int index = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                index = i;
                break;
            }
            set.add(nums[i]);
        }
        if (index == -1) return 0;
        int rem = (index + 1) % 3;
        if (rem == 0) return (index + 1) / 3;
        return ((index + 1) / 3) + 1;
    }
}

