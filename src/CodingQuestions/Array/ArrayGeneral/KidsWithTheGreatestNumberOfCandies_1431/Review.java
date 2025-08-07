package CodingQuestions.Array.ArrayGeneral.KidsWithTheGreatestNumberOfCandies_1431;

import java.util.ArrayList;
import java.util.List;

public class Review {
    public static void main(String[] args) {

    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> li = new ArrayList<>();
        int most = 0;
        for (Integer candy : candies) most = Math.max(most, candy);
        for (Integer candy : candies) {
            if (candy + extraCandies >= most) li.add(true);
            else li.add(false);
        }
        return li;
    }
}
