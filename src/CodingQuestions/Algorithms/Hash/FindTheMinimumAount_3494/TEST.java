package CodingQuestions.Algorithms.Hash.FindTheMinimumAount_3494;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        int[] skill = {1, 5, 2, 4};
        int[] mana = {5, 1, 4, 2};
        //5, 5+25, 30+10, 40 + 20
        //
        long result = solution.minTime(skill, mana);
        System.out.println("Result: " + result);
    }
    long minTime(int[] skill, int[] mana) {
        long[] endTime = new long[skill.length];
        Arrays.fill(endTime, 0);
        for(int i = 0; i < mana.length; ++i){
            long t = 0, maxDiff = 0;
            for(int j = 0; j < skill.length; ++j){
                maxDiff = Math.max(maxDiff, endTime[j] - t);
                t += (long)skill[j] * (long)mana[i];
                endTime[j] = t;
            }
            for(int j = 0; j < skill.length; ++j) {
                endTime[j] += maxDiff;
            }
        }
        return endTime[endTime.length-1];
    }
}
