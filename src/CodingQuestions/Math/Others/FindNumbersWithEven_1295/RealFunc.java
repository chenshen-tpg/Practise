package CodingQuestions.Math.Others.FindNumbersWithEven_1295;

public class RealFunc {
    public static void main(String[] args) {

    }
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int count = 0;
            while(num > 0) {
                num /= 10;
                count++;
            }
            if (count % 2 == 0) ans++;
        }
        return ans;
    }
}
