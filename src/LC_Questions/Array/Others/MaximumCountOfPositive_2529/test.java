package LC_Questions.Array.Others.MaximumCountOfPositive_2529;

public class test {
    public static void main(String[] args) {

    }
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) neg++;
            if (nums[i] > 0) pos++;
        }
        return Math.max(neg, pos);
    }
}
