package LC_Questions.Hash.Others.MinimumIndexOfAvalidSplit_2780;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MeTrying {
    public static void main(String[] args) {
        System.out.println(helper(Arrays.asList(2,1,3,1,1,1,7,1,2,1)));
    }
    public static int helper (List<Integer> arr) {
        if (arr == null || arr.size() == 0 || arr.size() == 1) return -1;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int midNum = 0, midLen = 0;
        for (int i = 0; i < arr.size(); i++) {
            hm.put(arr.get(i), hm.getOrDefault(arr.get(i), 0) + 1);
            if (hm.get(arr.get(i)) >= arr.size() / 2) {
                midNum = arr.get(i);
            }
        }
        midLen = hm.get(midNum);
        if (midLen % 2 == 0 && arr.size() % 2 == 1) return -1;
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == midNum) {
                count++;
                if (count == midLen / 2) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}
