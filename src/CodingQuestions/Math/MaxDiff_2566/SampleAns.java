package CodingQuestions.Math.MaxDiff_2566;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int n1 = 9, n2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (n1 == 9 && s.charAt(i) != '9') {
                n1 = (s.charAt(i)) - '0';
            }
            if (n2 == 0 && s.charAt(i) != '0') {
                n2 = (s.charAt(i)) - '0';
            }
        }
        StringBuilder val = new StringBuilder();
        int rem = 0;
        int a = 0, b = 0, k;
        while (num > 0) {
            a = num % 10;
            b = num % 10;
            if (a == n1) a = 9;
            if (b == n2) b = 0;
            k = a - b - rem;
            if (k < 0) {
                k = 10 - k;
                rem = -1;
            } else rem = 0;
            val.append(k);
            num /= 10;
        }
        return Integer.valueOf(val.reverse().toString());
    }
}
