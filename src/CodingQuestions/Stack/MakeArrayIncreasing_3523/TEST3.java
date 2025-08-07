package CodingQuestions.Stack.MakeArrayIncreasing_3523;

public class TEST3 {
    public static void main(String[] args) {

    }
    public int maximumPossibleSize(int[] nums) {
        int res = 0, pre = 0;
        for (int a: nums) {
            if (pre <= a) {
                pre = a;
                res++;
            }
        }
        return res;
    }
}
