package CodingQuestions.Algorithms.Heap.MimumOperationsToExceedThresholdValueII_3066;


import java.util.PriorityQueue;

public class MimumOperationsToExceedThresholdValueII_3066 {
    public static void main(String[] args) {
        int [] nums = {2 ,11, 10, 1, 3};
        System.out.println(calculate(nums, 10));
    }

    public static int calculate (int [] nums, int k) {
        int ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long)num);
        }
//        PriorityQueue<Long> pq = new PriorityQueue<Long>(
//                Arrays.stream(nums)
//                        .mapToLong(i -> (long) i)
//                        .boxed()
//                        .collect(Collectors.toList())
//        );
        while (pq.peek() < k) {
            if (pq.size() < 2) return -1;
            long x = pq.remove();
            long y = pq.remove();
//            pq.add(MatSolution.min(x, y) * 2 + MatSolution.max(x, y));
            pq.add(x * 2 + y);
            ans++;
        }
        return ans;
    }
}
