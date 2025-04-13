package LC_Questions.Array.ArrayGeneral.LC150.Candy_135;

import java.util.Arrays;

public class OnePass {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        OnePass c = new OnePass();
        System.out.println(c.candyModelAns(ratings));
    }
    //Initial thoughts
    // 1. if ratings[i-1] < ratings[i] or ratings[i-1] > ratings[i], count++
    // 2. if ratings[i-1] == ratings[i], count *= ratings[i] / ratings[i-1]
    public int candy(int[] ratings) {
        int count = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i-1] < ratings[i] || ratings[i-1] > ratings[i]){
                count += 1;
            } else if (ratings[i-1] * 2 < ratings[i]){
                count *= ratings[i] / ratings [i-1];
            }

        }
        return 0;
    }
    public int candyModelAns(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] &&  candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    hasChanged = true;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    hasChanged = true;
                }
            }
        }
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

}
