package CodingQuestions.Array.ArrayGeneral.LC150.Candy_135;

import java.util.Arrays;

public class OnePassRefinedAI {
    public static void main(String[] args) {
        OnePassRefinedAI solution = new OnePassRefinedAI();
        solution.candyModelAnsRefined(new int[] {1, 3, 5, 2, 4, 6, 3, 5, 7, 1});
    }
    public int candyModelAnsRefined(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        int lastChangedIndex = -1;
        while (true) {
            int currentChangedIndex = -1; // Track modifications in this pass
            for (int i = 0; i < n; i++) {
                if (i < n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    currentChangedIndex = i;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    currentChangedIndex = i;
                }
            }
            if (currentChangedIndex == -1) break;
            if (currentChangedIndex == lastChangedIndex) break;
            lastChangedIndex = currentChangedIndex;
        }
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}
