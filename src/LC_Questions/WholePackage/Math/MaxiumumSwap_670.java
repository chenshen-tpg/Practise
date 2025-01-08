package LC_Questions.WholePackage.Math;

import java.util.PriorityQueue;

public class MaxiumumSwap_670 {

    public static void main(String[] args) {
        int num = 2736;
        method(num);
    }

    private static int method(int num) {
        char [] numStr = Integer.toString(num).toCharArray();
        int maxDig = -1, fIndex = -1, sIndex = -1;
        for (int i = numStr.length - 1; i >= 0; i --) {
            if (maxDig == -1 || numStr[i] > numStr[maxDig]) maxDig = i;
            else if (numStr[i] < numStr[maxDig]) {
                fIndex = i;
                sIndex = maxDig;
            }
        }
        if (fIndex != -1 && sIndex !=-1) {
            char temp = numStr[fIndex];
            numStr[fIndex] = numStr[sIndex];
            numStr[sIndex] = temp;
        }
        return Integer.parseInt(new String(numStr));
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

    public static int method_Wrong (int num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->b - a);
        String str = Integer.toString(num);
        for (char c : str.toCharArray()) {
            pq.add(Character.getNumericValue(c));
        }
        int result = 0;
        while (!pq.isEmpty()) {
            result = result * 10 + pq.poll();
        }
        return result;
    }
}
