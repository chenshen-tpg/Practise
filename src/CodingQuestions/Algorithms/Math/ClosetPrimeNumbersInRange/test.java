package CodingQuestions.Algorithms.Math.ClosetPrimeNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        test solution = new test();
        solution.closestPrimes(10,19);
    }

    public int[] closestPrimes(int left, int right) {
        int one = -1, two = -1;
        List<Integer> li = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                li.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < li.size(); i++) {
            if (li.get(i) - li.get(i - 1) < min){
                one = li.get(i - 1);
                two = li.get(i);
                min = li.get(i) - li.get(i-1);
            }
        }
        return new int [] {one, two};
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
