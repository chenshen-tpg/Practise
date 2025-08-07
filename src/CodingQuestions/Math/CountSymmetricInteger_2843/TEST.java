package CodingQuestions.Math.CountSymmetricInteger_2843;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.countSymmetricIntegers(1200,1230);
    }
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        while (low <= high) {
            int temp = String.valueOf(low).length();
            if (temp % 2 == 0) {
                if (helper(low, temp)) count++;
            }
            low++;
        }
        return count;
    }

    public boolean helper(int num, int len) {
        int left = 0, right = 0, count = 0;
        while (num > 0) {
            int digit = num % 10;
            if (count++ < len / 2) left += digit;
            else right += digit;
            num /= 10;
        }
        return left == right;
    }
}
