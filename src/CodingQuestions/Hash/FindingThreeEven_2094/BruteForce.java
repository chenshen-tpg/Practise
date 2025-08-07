package CodingQuestions.Hash.FindingThreeEven_2094;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BruteForce {
    public static void main(String[] args) {

    }


    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        Arrays.sort(digits);
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0 ; j < digits.length; j++) {
                for (int k = 0; k <digits.length; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int temp = digits[i] * 100 + digits[j] * 10 + digits[k] ;
                    if (temp % 2 == 0 && temp >= 100) {
                        nums.add(temp);
                    }
                }
            }
        }
        int index = 0;
        int[] result = new int[nums.size()];
        for (int num : nums) {
            result[index++] = num;
        }
        Arrays.sort(result);
        return result;
    }
}
