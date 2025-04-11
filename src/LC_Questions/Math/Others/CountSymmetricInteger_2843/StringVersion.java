package LC_Questions.Math.Others.CountSymmetricInteger_2843;

public class StringVersion {
    public static void main(String[] args) {

    }
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int len = s.length();
            if (len % 2 == 0) {
                if (isSymmetric(s)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isSymmetric(String s) {
        int n = s.length();
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n / 2; i++) {
            leftSum += Character.getNumericValue(s.charAt(i));
            rightSum += Character.getNumericValue(s.charAt(n - 1 - i));
        }
        return leftSum == rightSum;
    }
}
