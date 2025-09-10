package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.TopKFrequentElements_347;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int [k];
        HashMap<Integer, Integer> hm = new HashMap();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b)-> b[1]-a[1]);
        for (int h : hm.keySet()) {
            pq.add(new int [] {h, hm.get(h)});
        }
        int index = 0;
        while (index < k) {
            res[index++] = pq.poll()[0];
        }
        return res;
    }
}
