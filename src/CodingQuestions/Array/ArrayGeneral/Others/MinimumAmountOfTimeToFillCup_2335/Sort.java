package CodingQuestions.Array.ArrayGeneral.Others.MinimumAmountOfTimeToFillCup_2335;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {

    }
    public int fillCups(int[] amount) {
        int res = 0;
        while (amount[0] > 0 || amount[1] > 0 || amount[2] > 0) {
            Arrays.sort(amount);
            if (amount[1] > 0 && amount[2] > 0) {
                amount[1]--;
                amount[2]--;
                res++;
            } else if (amount[2] > 0){
                amount[2]--;
                res++;
            }
        }
        return res;
    }
}
