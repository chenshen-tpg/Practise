package CodingQuestions.Array.ArrayGeneral.NumberOfEquivlent_1128;

import java.util.HashMap;

public class Wrong {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {1, 2},
                {1, 1},
                {1, 2},
                {2, 2}
        };
        Wrong solution = new Wrong();
        solution.numEquivDominoPairs(arr);

    }
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 1;
        for (int [] domino : dominoes) {
            hm.put(domino[0], domino[1]);
            if (hm.containsKey(domino[0]) && hm.get(domino[0]) == domino[0] || hm.containsValue(domino[1]) && hm.get(domino[1]) == domino[0]) count++;

        }
        return count;
    }
}
