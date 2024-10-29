package LC_Questions.LC_75.ArrayString;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies_1431 {
    public static void main(String[] args) {

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
