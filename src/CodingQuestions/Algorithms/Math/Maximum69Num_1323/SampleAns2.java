package CodingQuestions.Algorithms.Math.Maximum69Num_1323;

public class SampleAns2 {
    public static void main(String[] args) {

    }

    public int maximum69Number(int num) {
        String temp = num + "";
        int s = temp.length();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '6') {
                s = i;
                break;
            }
        }
        return num + (int) (3 * Math.pow(10, temp.length() - s - 1));
    }
}
