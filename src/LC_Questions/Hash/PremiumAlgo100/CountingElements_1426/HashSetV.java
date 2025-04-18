package LC_Questions.Hash.PremiumAlgo100.CountingElements_1426;

import java.util.HashSet;

public class HashSetV {
    public static void main(String[] args) {
        HashSetV solution = new HashSetV();
        solution.countElements(new int [] {1,3,2,3,5,0});
    }
    public int countElements(int[] arr) {
        HashSet<Integer> hm = new HashSet();
        int count = 0;
        for (int i = 0; i < arr.length; i++) hm.add(arr[i]);
        for (int i = 0; i < arr.length; i++) {
            if (hm.contains(arr[i] + 1)) count++;
        }
        return count;
    }
}
