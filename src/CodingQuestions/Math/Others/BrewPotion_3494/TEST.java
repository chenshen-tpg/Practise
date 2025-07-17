package CodingQuestions.Math.Others.BrewPotion_3494;

public class TEST {
    public static void main(String[] args) {
        int[] skill = {1, 5, 2, 4}, mana = {5, 1, 4, 2};
        TEST solution = new TEST();
        solution.minTime(skill, mana);
    }

    long minTime(int[] skill, int[] mana) {
        long[] memo = new long[skill.length];
        for (int i = 0; i < mana.length; i++) {
            long time = 0, diff = 0;
            for (int j = 0; j < skill.length; j++) {
                diff = Math.max(diff, memo[j] - time);
//                System.out.println(diff);
                time += (long) skill[j] * (long) mana[i];
                memo[j] = time;
            }
            for (int j = 0; j < skill.length; j++) {
                memo[j] += diff;
            }
        }
        return memo[memo.length - 1];
    }
}
