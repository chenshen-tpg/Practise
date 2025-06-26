package LC_Questions.Array.ArrayGeneral.Others.FindAllKIndicesInArray_2200;

import java.util.ArrayList;
import java.util.List;

public class SampleAns2 {
    public static void main(String[] args) {

    }
//left right scan once hsving the key
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int r = 0;
        int n = nums.length;
        for (int j = 0; j < n; ++j) {
            if (nums[j] == key) {
                int l = Math.max(r, j - k);
                r = Math.min(n - 1, j + k) + 1;
                for (int i = l; i < r; ++i) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
