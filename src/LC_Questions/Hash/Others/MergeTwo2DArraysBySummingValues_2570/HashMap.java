package LC_Questions.Hash.Others.MergeTwo2DArraysBySummingValues_2570;

import java.util.Map;
import java.util.TreeMap;

public class HashMap {
    public static void main(String[] args) {
        helper(new int [][] {{1,2},{2,3},{4,5}}, new int [][] {{1,4},{3,2},{4,1}});
    }

    public static int[][] helper(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> hm = new TreeMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hm.put(nums1[i][0], nums1[i][1]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hm.containsKey(nums2[i][0])) {
                hm.put(nums2[i][0], hm.get(nums2[i][0]) + nums2[i][1]);
            } else {
                hm.put(nums2[i][0],nums2[i][1]);
            }
        }
        int [][] res = new int [hm.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            res[index][0] = entry.getKey();
            res[index][1] = entry.getValue();
            index++;
        }
        return res;
    }
}
