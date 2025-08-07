package CodingQuestions.Array.Prefix.MakeThePrefixSumNonNegative_2599;

import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) {
        int [] nums = {2,3,-5,4};
        makePrefix(nums);
    }

    public static int makePrefix(int [] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int countZero = 0, len = nums.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) pq.add(nums[i]);
            temp += nums[i];
            if (temp < 0)  {
                pq.poll();
                countZero++;
            }
        }
        return countZero;
    }
}
