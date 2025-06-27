package LC_Questions.Array.ArrayGeneral.Others.ThirdLargest_414;

import java.util.HashSet;

public class TEST {
    public static void main(String[] args) {

    }
    public int thirdMax(int[] nums) {
        int res = Integer.MIN_VALUE;
        HashSet<Integer> hs = new HashSet();
        for (int num : nums) {
            if (!hs.contains(num)) {
                hs.add(num);
                if (hs.size() == 3) {
                    return num;
                }
            }
            res = Math.max(res, num);
        }
        return res;
    }

}
