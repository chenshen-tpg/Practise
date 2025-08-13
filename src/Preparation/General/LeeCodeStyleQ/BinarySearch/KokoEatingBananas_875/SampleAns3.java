package Preparation.General.LeeCodeStyleQ.BinarySearch.KokoEatingBananas_875;

public class SampleAns3 {
    public static void main(String[] args) {

    }
    public Integer minHarvestRate(int[] apples, Integer h) {
        int l = 1, r = 1;
        for (int apple : apples) {
            r = Math.max(r, apple);
        }
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int time = 0;
            for (int apple : apples) {
                time += (apple + mid - 1) / mid;
            }
            if (time <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
