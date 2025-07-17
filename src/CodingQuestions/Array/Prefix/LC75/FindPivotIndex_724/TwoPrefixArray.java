package CodingQuestions.Array.Prefix.LC75.FindPivotIndex_724;

public class TwoPrefixArray {
    public static void main(String[] args) {
        TwoPrefixArray f = new TwoPrefixArray();
        System.out.println(f.rewrite(new int[]{1, 7, 3, 6, 5, 6}));
        
    }

    private int rewrite (int[] nums) {
        int [] leftToRight = new int [nums.length];
        int [] rightToLeft = new int [nums.length];
        int tempF = 0;
        for (int i = 0; i < nums.length; i++) {
            tempF += nums[i];
            leftToRight[i] = tempF;
        }
        int tempB = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            tempB += nums[i];
            rightToLeft[i] += tempB;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftToRight[i] == rightToLeft[i]) {
                return i;
            }
        }
        return -1;
    }


    private int pivotIndex(int[] nums) {
        int left = 0, sum =0;
        for (int num:nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (left == sum - nums[i] - left) return i;
            left += nums[i];
        }
        return -1;
    }
}
