package CodingQuestions.Algorithms.Array.ArrayGeneral.ThirdMaximumNumber_414;

import java.util.PriorityQueue;
import java.util.Queue;

public class MeTrying {

//    Example 1:
//    Input: nums = [3,2,1]
//    Output: 1
//    Explanation:
//    The first distinct maximum is 3.
//    The second distinct maximum is 2.
//    The third distinct maximum is 1.
//    Example 2:
//    Input: nums = [1,2]
//    Output: 2
//    Explanation:
//    The first distinct maximum is 2.
//    The second distinct maximum is 1.
//    The third distinct maximum does not exist, so the maximum (2) is returned instead.
//    Example 3:
//    Input: nums = [2,2,3,1]
//    Output: 1
//    Explanation:
//    The first distinct maximum is 3.
//    The second distinct maximum is 2 (both 2's are counted together since they have the same value).
//    The third distinct maximum is 1.
    public static void main(String[] args) {
        helper(new int [] {1,2,2,5,3,5});
    }

    public static int helper (int [] nums) {
        if (nums.length == 1) return nums[0];
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (!pq.contains(num)) {
                pq.add(num);
            }
        }
        if (pq.size() == 2) {
            pq.poll();
        }
        else if (pq.size() > 3) {
            int temp = pq.size() - 3;
            while(temp > 0) {
                pq.poll();
                temp--;
            }
        }
        return pq.poll();
    }
}
