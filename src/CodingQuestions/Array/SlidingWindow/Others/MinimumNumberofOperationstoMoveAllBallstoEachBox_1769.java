package CodingQuestions.Array.SlidingWindow.Others;

public class MinimumNumberofOperationstoMoveAllBallstoEachBox_1769 {
    public static void main(String[] args) {
        String boxes = "001011";
        // 11 => 2-0, 4-0, 5-0  11
        // 8 -> 3-1, 4-1, 5-1  8
        // 5 -> 4-2, 5-2       4
        // 4 -> 2+1, 4-1, 5-2  3
        //
        helper_sum(boxes);
        helper_sum_model(boxes);
    }

    public static int [] helper(String arr) {
        int[] res = new int [arr.length()];
        int resIndex = 0;
        for (int i = 0; i < arr.length(); i++) {
            for (int j = 0; j < arr.length(); j++) {
                if (arr.charAt(j) == '1') {
//                    if (j - i > 0) {
//                        res[resIndex] += j - i;
//                    } else {
//                        res[resIndex] += i - j;
//                    }
                    res[resIndex] += Math.abs(i-j);
                }
            }
            resIndex++;
        }
        return res;
    }
    public static int [] helper_sum (String arr) {
        int [] res = new int [arr.length()];
        int rightSum = 0, rightBalls = 0;
        int leftSum = 0, leftBalls = 0;
        for (int i = 0; i < arr.length(); i++) {
            res[i] += rightSum;
            if (arr.charAt(i) == '1') rightBalls ++;
            rightSum += rightBalls;

            res[arr.length() - i - 1] += leftSum;
            if (arr.charAt(arr.length() - i -1) == '1') leftBalls ++;
            leftSum += leftBalls;
        }
        return res;
    }
    public static int [] helper_sum_model (String arr) {
        int n = arr.length();
        int[] answer = new int[n];
        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;

        for (int i = 0; i < n; i++) {
            answer[i] += movesToLeft;
            ballsToLeft += Character.getNumericValue(arr.charAt(i));
            movesToLeft += ballsToLeft;
            int j = n - 1 - i;
            answer[j] += movesToRight;
            ballsToRight += Character.getNumericValue(arr.charAt(j));
            movesToRight += ballsToRight;
        }

        return answer;
    }
}
