package LC_Questions.Array.ArrayGeneral.PremiumAlgo100.MaximumDistanceInArray_624;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnePassWrong {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(1, 2, 3)
        ));
        System.out.println(helper(list));
    }
    public static int helper (List<List<Integer>> li) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < li.size(); i++) {
            //no swap..
            if (li.get(i).get(0) < min) min = li.get(i).get(0);
            if (li.get(i).get(li.get(i).size() -1) > max) max = li.get(i).get(li.get(i).size() -1);
        }
        return max - min;
    }
}
