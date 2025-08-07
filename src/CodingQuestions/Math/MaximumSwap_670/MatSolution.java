package CodingQuestions.Math.MaximumSwap_670;


public class MatSolution {

    public static void main(String[] args) {
        MatSolution solution = new MatSolution();
        int num = 2736;
        solution.maximumSwap(num);
    }



    public int maximumSwap(int num) {
        int res = num;
        int diff = 0;
        int maxDigit = -1;
        int maxDigitPos = 0;
        int topDigitPos = 1;
        while (num > 0) {
            int curDigit = num % 10;
            if (curDigit > maxDigit) {
                maxDigit = curDigit;
                maxDigitPos = topDigitPos;
            } else {
                diff = Math.max(diff, maxDigit * (topDigitPos - maxDigitPos) - curDigit * (topDigitPos - maxDigitPos));
            }
            topDigitPos *= 10;
            num /= 10;
        }
        return res + diff;
    }
}
