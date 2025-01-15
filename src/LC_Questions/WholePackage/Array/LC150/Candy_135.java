package LC_Questions.WholePackage.Array.LC150;

import java.util.Arrays;

public class Candy_135 {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        Candy_135 c = new Candy_135();
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
    public int candy1(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
}
