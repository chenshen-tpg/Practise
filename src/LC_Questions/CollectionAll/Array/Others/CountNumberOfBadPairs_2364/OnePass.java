package LC_Questions.CollectionAll.Array.Others.CountNumberOfBadPairs_2364;

public class OnePass {
    public static void main(String[] args) {
        int [] nums = {4,1,3,3};
        BruteForce_TLE solution = new BruteForce_TLE();
        solution.count(nums);
    }
    public long count (int [] nums) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i != nums[j] - nums[i]) count++;
            }
        }
        return count;
    }
}
