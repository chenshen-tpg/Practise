package CodingQuestions.Algorithms.Array.BitManipulation.MinimizeXor_2429_REVIEW;

public class MinimizeXor_2429 {
    public static void main(String[] args) {
        int nums1 = 3, nums2 = 5;
        //3 0011
        //5 0101
        //12 1100
        // same number of bits, means 1100
        // minimal mean's all the way to right

        minimizeXor(nums1,nums2);
    }

    public static int minimizeXor(int num1, int num2) {
        int countBitsNum2 = 0;
//        while (num2 > 0) {
//            if ((num2 & 1) == 1) {
//                countBitsNum2++;
//            }
//            num2 >>= 1;
//        }
        countBitsNum2 = Integer.bitCount(num2);
        int result = 0;

//        The most significant bits of num1 are preserved in result as long as there are 1-bits left to set
        for (int i = 31; i >= 0 && countBitsNum2 > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i);
                countBitsNum2--;
            }
        }
//        This ensures that the remaining 1-bits are set in the least significant positions to minimize the value of result.
        for (int i = 0; i < 32 && countBitsNum2 > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i);
                countBitsNum2--;
            }
        }

        return result;
    }
}
