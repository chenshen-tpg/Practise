package LC_Questions.Array.Others;

public class longestProductEquivalentSubarray_3411 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 6, 12};
        System.out.println(longestProductEquivalentSubarray_3411_Q1(nums)); // Output: 3
    }

    public static int longestProductEquivalentSubarray_3411_Q1(int[] nums) {
        int maxLength = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int product = 1;
            int gcd = nums[i];
            int lcm = nums[i];

            for (int j = i; j < n; j++) {
                product *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);

                if (product == gcd * lcm) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

//    private static int gcd(int a, int b) {
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }
    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

}
