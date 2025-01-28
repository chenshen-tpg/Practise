package LC_Questions.CollectionAll.Heap.Others;

import Lib.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKPairswithSmallestSums_373_MED {

    public static void main(String[] args) {
        FindKPairswithSmallestSums_373_MED f = new FindKPairswithSmallestSums_373_MED();
        List<List<Integer>> res = f.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->(a[0] - b[0]));
        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair<Integer, Integer>(0, 0));

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if (i + 1 < m && !visited.contains(new Pair<Integer, Integer>(i + 1, j))) {
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pair<Integer, Integer>(i + 1, j));
            }

            if (j + 1 < n && !visited.contains(new Pair<Integer, Integer>(i, j + 1))) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pair<Integer, Integer>(i, j + 1));
            }
        }

        return ans;
    }
    public List<int[]> kSmallestPairsSingleRound(int[] nums1, int[] nums2, int k) {
        PriorityQueue <int[]> q = new PriorityQueue<>((a,b)-> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new ArrayList<>();
        if (nums1.length==0 || nums2.length==0 || k==0) return res;
        for (int i=0; i <nums1.length && i < k; i++) q.offer(new int[]{nums1[i], nums2[0], 0});
        while (k-- > 0 && !q.isEmpty()){
            int[] cur = q.poll();
            res.add (new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length-1) continue;
            q.offer (new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
}
