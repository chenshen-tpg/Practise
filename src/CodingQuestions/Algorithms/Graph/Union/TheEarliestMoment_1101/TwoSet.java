package CodingQuestions.Algorithms.Graph.Union.TheEarliestMoment_1101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSet {
    public static void main(String[] args) {
        int[][] logs = {
                {20190101, 0, 1},
                {20190104, 3, 4},
                {20190107, 2, 3},
                {20190211, 1, 5},
                {20190224, 2, 4},
                {20190301, 0, 3},
                {20190312, 1, 2},
                {20190322, 4, 5}
        };
        int n = 6;
        TwoSet twoSet = new TwoSet();
        int result = twoSet.helper(logs, n);
        System.out.println("The earliest moment when everyone becomes friends: " + result);
    }

    public int helper(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            sets.add(set);
        }

        for (int[] log : logs) {
            int time = log[0];
            int friend1 = log[1];
            int friend2 = log[2];
            Set<Integer> set1 = findSet(sets, friend1);
            Set<Integer> set2 = findSet(sets, friend2);
            if (set1 != set2) {
                set1.addAll(set2);
                sets.remove(set2);
            }
            if (sets.size() == 1) {
                return time;
            }
        }

        return -1;
    }
    private Set<Integer> findSet(List<Set<Integer>> sets, int friend) {
        for (Set<Integer> set : sets) {
            if (set.contains(friend)) {
                return set;
            }
        }
        return null;
    }
}
