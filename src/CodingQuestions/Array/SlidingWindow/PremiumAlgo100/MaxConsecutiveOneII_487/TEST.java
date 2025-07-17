package CodingQuestions.Array.SlidingWindow.PremiumAlgo100.MaxConsecutiveOneII_487;

public class TEST {

    public static void main(String[] args) {
        System.out.println(String.valueOf(11).length());
        System.out.println(1200 / 10);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0, count = 0, i, max = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count++;
            while (count == 2) {
                if (nums[j] == 0) count--;
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
