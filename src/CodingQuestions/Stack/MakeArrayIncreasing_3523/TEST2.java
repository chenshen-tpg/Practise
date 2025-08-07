package CodingQuestions.Stack.MakeArrayIncreasing_3523;

public class TEST2 {
    public static void main(String[] args) {

    }
    public int maximumPossibleSize(int[] nums) {
        int count = 0, ans = 0;
        for (int num :nums) {
            if (num >= count) {
                count = num;
                ans++;
            }
        }
        return ans;
    }
}
