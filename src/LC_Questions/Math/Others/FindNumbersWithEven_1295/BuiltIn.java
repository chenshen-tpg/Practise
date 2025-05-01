package LC_Questions.Math.Others.FindNumbersWithEven_1295;

public class BuiltIn {
    public static void main(String[] args) {

    }
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) if (String.valueOf(num).length() % 2 == 0) ans++;
        return ans;
    }
}
