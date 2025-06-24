package LC_Questions.Array.ArrayGeneral.Others.FindAllKIndicesInArray_2200;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.findKDistantIndices(new int [] {3,4,9,1,3,9,5}, 9, 1);
    }
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                while (j <= i) {
                    if (Math.abs(i - j) <= k && !res.contains(i)) {
                        res.add(i);
                    }
                    j++;
                }
            }
        }
        return res;
    }
}
