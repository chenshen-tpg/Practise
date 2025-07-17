package CodingQuestions.Math.Others.Unique3DigitsEven_3483;

import java.util.HashSet;

public class MeTrying {

    public static void main(String[] args) {

    }


    public int totalNumbers(int[] digits) {
        HashSet<Integer> li = new HashSet<>();
        int cnt = 0;
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && i != k && j != k && digits[i] != 0 && digits[k] % 2 == 0) {
                        int cur = digits[i] * 100 + digits[j] * 10 + digits[k];
                        li.add(cur);
                    }
                }
            }
        }
        return li.size();
    }
}
