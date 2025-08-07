package CodingQuestions.Array.ArrayGeneral.MaximumDistanceInArray_624;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnePass {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(1, 2, 3)
        ));
        System.out.println(helper(list));
    }
    public static int helper (List<List<Integer>> li) {
        if (li == null || li.isEmpty() || li.get(0).isEmpty()) return 0;
        int max = li.get(0).get(li.get(0).size()-1), min = li.get(0).get(0), res = 0;
        for (int i = 1; i < li.size(); i++) {
            int n = li.get(i).size();
            //key is to store and swap
            int swap = Math.max(Math.abs(li.get(i).get(n - 1) - min), Math.abs(max - li.get(i).get(0)));
            res = Math.max(res, swap);
            min = Math.min(min, li.get(i).get(0));
            max = Math.max(max, li.get(i).get(li.get(i).size() - 1));
        }
        return res;
    }
}
