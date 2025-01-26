package LC_Questions.WholePackage.Array.Others.MultipleStrings;


import java.util.Arrays;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichesPile {
    public static void main(String[] args) {
        int[] a = {25,64,9,4,100};
        int k = 4;
        long result = pickGifts(a, k);
        System.out.println("Result: " + result); // Output: 20
    }

    public static int helper(int [] a, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int max = 0, l = 0;
            for (int j = 0; j < a.length; j++) {
               if (a[j] > max) {
                   max = a[j];
                   l = j;
               }
            }
            a[l] = (int) Math.floor(Math.sqrt(a[l]));
        }
        for(int i = 0; i < a.length; i++) {
            ans += a[i];
        }
        return ans;
    }
    public static int helper2(int [] a, int k) {
        int ans = 0;
        Arrays.sort(a);
        for (int i = a.length - 1; i >= a.length - k ; i--) {
            a[i] = (int) Math.floor(Math.sqrt(a[i]));
        }
        // wrong because it will not take 10 again..
        for(int i = 0; i < a.length; i++) {
            ans += a[i];
        }
        return ans;
    }
    public static long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        for (int g: gifts) maxHeap.add(g);
        while(k-- > 0) maxHeap.add((int)Math.sqrt(maxHeap.poll()));
        while(!maxHeap.isEmpty()) ans+= maxHeap.poll();
        return ans;
    }

}
