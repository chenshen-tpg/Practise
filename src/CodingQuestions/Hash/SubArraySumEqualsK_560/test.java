package CodingQuestions.Hash.SubArraySumEqualsK_560;

public class test {
    public static void main(String[] args) {
        int [] test = {1,2,3,4,7,6,1,1,2};
        SubArraySum s = new SubArraySum();
        System.out.println(s.subarraySum(test,7));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        int[] prefixSums = new int[1001];
        for (int num : nums) {
            currSum += num;
            if (currSum == k) count++;
            if (currSum - k >= 0 && currSum - k < prefixSums.length){
                count += prefixSums[currSum - k];
            }
            if (currSum >= 0 && currSum < prefixSums.length){
                prefixSums[currSum]++;
            }
        }
        return count;
    }
}
