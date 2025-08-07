package CodingQuestions.Math.ClosetPrimeNumbersInRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.closestPrimes(10,19);
    }
    public int[] closestPrimes(int left, int right) {
        int[] memo = sieve(right);
        List<Integer> li = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (memo[i] == 1) {
                li.add(i);
            }
        }
        if (li.size() < 2) return new int[] { -1, -1 };
        int minDifference = Integer.MAX_VALUE;
        int[] closestPair = new int[2];
        Arrays.fill(closestPair, -1);
        for (int i = 1; i < li.size(); i++) {
            int difference = li.get(i) - li.get(i - 1);
            if (difference < minDifference) {
                minDifference = difference;
                closestPair[0] = li.get(i - 1);
                closestPair[1] = li.get(i);
            }
        }

        return closestPair;
    }

    private int[] sieve(int upperLimit) {
        int[] sieve = new int[upperLimit + 1];
        Arrays.fill(sieve, 1);
        sieve[0] = 0;
        sieve[1] = 0;
        for (int i = 2; i * i <= upperLimit; i++) {
            if (sieve[i] == 1) {
                for (int multiple = i * i; multiple <= upperLimit; multiple += i) {
                    sieve[multiple] = 0;
                }
            }
        }
        return sieve;
    }
}
