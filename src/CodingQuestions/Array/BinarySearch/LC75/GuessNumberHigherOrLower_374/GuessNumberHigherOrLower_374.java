package CodingQuestions.Array.BinarySearch.LC75.GuessNumberHigherOrLower_374;

public class GuessNumberHigherOrLower_374 {
    public static void main(String[] args) {
        int n = 10;
    }

    public int guessNumber(int n, int pick) {
        int right = n, left = 0;
        while (left < right) {
            int mid = left + right / 2;
            int res = guess(mid);
            if (res == -1) right = mid - 1;
            else if (res == 0) return 1;
            else left = mid + 1;
        }
        return -1;
    }

    private int guess(int mid) {
        return mid;
    }
}
