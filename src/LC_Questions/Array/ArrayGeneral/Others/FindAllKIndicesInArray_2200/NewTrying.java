package LC_Questions.Array.ArrayGeneral.Others.FindAllKIndicesInArray_2200;

import java.util.ArrayList;
import java.util.List;

public class NewTrying {
    public static void main(String[] args) {

    }
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int forward = i;
                int backward = i;
                while (backward >= 0 && Math.abs(forward -i) <= k && !res.contains(i) ) {
                    res.add(forward);
                    forward--;
                }
                while (forward < nums.length && Math.abs(forward -i) <= k && !res.contains(i) ) {
                    if (nums[forward] == key) break;
                    res.add(forward);
                    forward++;
                }
            }
        }
        return res;
    }
}
