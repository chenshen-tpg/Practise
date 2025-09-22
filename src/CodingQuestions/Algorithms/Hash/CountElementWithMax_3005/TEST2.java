package CodingQuestions.Algorithms.Hash.CountElementWithMax_3005;

public class TEST2 {
    public static void main(String[] args) {

    }
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        for (int num : nums) {
            freq[num]++;
            max = Math.max(max, freq[num]);
        }
        int ans = 0;
        for (int i = 0; i < 101; i++) {
            if (freq[i] == max) {
                ans += freq[i];
            }
        }
        return ans;
    }
}
