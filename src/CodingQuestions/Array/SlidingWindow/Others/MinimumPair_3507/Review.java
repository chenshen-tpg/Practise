package CodingQuestions.Array.SlidingWindow.Others.MinimumPair_3507;

import java.util.ArrayList;
import java.util.List;

public class Review {
    public static void main(String[] args) {
        Review solution = new Review();
        solution.minimumPairRemoval(new int [] {5,2,3,1});
    }

    public int minimumPairRemoval(int[] ints) {
        int ans = 0;
        ArrayList<Integer> newLi = new ArrayList<>();
        for (Integer i : ints) newLi.add(i);
        if (newLi.size() < 2) return ans;
        while(!checkInc(newLi)) {
            int index = -1, sum = Integer.MAX_VALUE;
            for (int i = 1; i < newLi.size(); i++) {
                if (newLi.get(i - 1) + newLi.get(i) < sum) {
                    sum = newLi.get(i - 1) + newLi.get(i);
                    index = i - 1;
                }
            }
            if (index != -1) {
                newLi.remove(index + 1);
                newLi.set(index, sum);
                ans++;
            }
        }
        return ans;
    }
    private boolean checkInc(List<Integer> ints) {
        for (int i = 1; i < ints.size(); i++) {
            if (ints.get(i - 1) > ints.get(i)) return false;
        }
        return true;
    }
}
