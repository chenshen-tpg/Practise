package LC_Questions.Hash.Others.FindAnagram_760;

import java.util.HashMap;
import java.util.TreeMap;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.anagramMappings(new int [] {12,28,46,32,50}, new int [] {50,12,32,46,28});
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
