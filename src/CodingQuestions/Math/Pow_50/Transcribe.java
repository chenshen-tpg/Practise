package CodingQuestions.Math.Pow_50;

public class Transcribe {
    public static void main(String[] args) {

    }
    public double helper (double x, long n) {
        if (n == 0) return 1;
        if (n < 0) n *= -1;
        x /= 1.0;
        double result = 1;
        while (n!=0) {
            if (n % 2 == 1) {
                result *= x;
                n--;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }
}
