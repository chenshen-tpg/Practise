package CodingQuestions.Array.BinarySearch.LC75.SuccessfulPairsofSpellsandPotions_2300;

import java.util.Arrays;

public class SampleAns1 {

    public static void main(String[] args) {

    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                long product = (long) spells[i] * potions[mid];
                if (product >= success) right = mid - 1;
                else left = mid + 1;
            }
            res[i] = potions.length - left;
        }
        return res;
    }
}
