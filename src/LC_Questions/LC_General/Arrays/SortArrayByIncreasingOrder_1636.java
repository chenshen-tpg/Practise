package LC_Questions.LC_General.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayByIncreasingOrder_1636 {
    public static void main(String[] args) {
        sort();
    }
    public static void sort(){
        int[] arr = {2,3,1,3,2};
        int [] ans = new int[arr.length];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().compareTo(b.getValue())
        );
        pq.addAll(hm.entrySet());
        int cal = 0;
        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> entry = pq.poll();
            int index = entry.getValue();
            while(index > 0){
                ans[cal++] = entry.getKey();
                index--;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + "");
        }
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }
        return nums;
    }
}
