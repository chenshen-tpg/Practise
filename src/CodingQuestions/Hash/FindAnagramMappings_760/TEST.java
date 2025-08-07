package CodingQuestions.Hash.FindAnagramMappings_760;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {

    }
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int [] ans = new int [nums1.length];
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            hm.put(nums2[i],i);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }
}
