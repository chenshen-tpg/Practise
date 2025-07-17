package CodingQuestions.Math.Others.MinimalEqualSum_2918;

public class PreCal {

    public static void main(String[] args) {

    }
    public long minSum(int[] nums1, int[] nums2) {
        long countF = 0, countS = 0, countFZ = 0, countSZ = 0;
        for (int num : nums1) {
            if (num == 0) {
                countF++;
                countFZ++;
            }
            countF += num;
        }
        for (int num : nums2) {
            if (num == 0) {
                countS++;
                countSZ++;
            }
            countS += num;
        }
        if ((countF > countS && countSZ == 0) || (countF < countS && countFZ == 0)) {
            return -1;
        }
        return Math.max(countF, countS);
    }
}
