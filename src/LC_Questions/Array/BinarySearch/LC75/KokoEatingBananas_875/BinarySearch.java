package LC_Questions.Array.BinarySearch.LC75.KokoEatingBananas_875;

public class BinarySearch {
    public static void main(String[] args) {

    }
    public int helper(int [] piles, int h) {
        int right = 1,  left = 1;
        for (int pile : piles) right = Math.max(right, pile);
        while(left < right) {
            int time = 0;
            int middle = left + (right - left) / 2;
            for (int pile : piles) time += Math.ceil((double) pile / middle);
            if (time <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
