package LC_Questions.CollectionAll.BinarySearch.LC75.SuccessfulPairsofSpellsandPotions_2300_review;

import java.util.Arrays;

public class sortBiinarySearch {
    public static void main(String[] args) {
        int [] spells = {5, 1, 3};
        int [] potions = {1, 2, 3, 4, 5};
        int success = 7;
        sortBiinarySearch solution = new sortBiinarySearch();
        solution.successfulPairs(spells, potions, success);
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int [] ans = new int [spells.length];
        int maxPotions = potions[potions.length-1];
        for (int i = 0; i < spells.length; i++) {
            long minPotion = (long) Math.ceil((1.0 * success) / spells[i]);
            if (minPotion > maxPotions) {
                ans[i] = 0;
                continue;
            }
            int index = lowerBound(potions, (int)minPotion);
            ans[i] = potions.length - index;
        }
        return ans;
    }

    private int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
