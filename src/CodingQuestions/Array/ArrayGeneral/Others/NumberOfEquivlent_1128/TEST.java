package CodingQuestions.Array.ArrayGeneral.Others.NumberOfEquivlent_1128;

public class TEST {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {1, 2},
                {1, 1},
                {1, 2},
                {2, 2},
                {1, 2}
        };
        numEquivDominoPairs(arr);
    }
    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int res = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            res += num[val];
            num[val]++;
        }
        return res;
    }
}
