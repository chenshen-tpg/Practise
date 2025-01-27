package LC_Questions.CollectionAll.Array.LC75;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies_1431_easy {
    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies_1431_easy k = new KidsWithTheGreatestNumberOfCandies_1431_easy();
        int[] candies = new int[]{2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> bo = k.kidsWithCandies(candies, extraCandies);
        for (Boolean b : bo) {
            System.out.println(b);
        }
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> bo = new ArrayList<>();
        int max = 0;
        for (int i = 0; i <candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            Boolean tf = candies[i] + extraCandies >= max ? true : false;
            bo.add(tf);
        }
        return bo;
    }
}
