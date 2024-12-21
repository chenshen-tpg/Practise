package LC_Questions.LC_150.Heap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKPairswithSmallestSums_373_MED {
    public class Pair<K, V> {

        private final K element0;
        private final V element1;

        public <K, V> Pair<K, V> createPair(K element0, V element1) {
            return new Pair<K, V>(element0, element1);
        }

        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public K getElement0() {
            return element0;
        }

        public V getElement1() {
            return element1;
        }

    }
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
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
}
