package CodingQuestions.Algorithms.Array.Prefix.FindTheHiestAltitude_1732;

public class Iteration {
    public static void main(String[] args) {
        int [] gain = new int[]{-5, 1, 5, 0, -7};
        System.out.println(method(gain));
    }
    public static int method (int [] gain) {
        int temp = 0;
        int res = 0;
        for (int i = 0; i < gain.length; i++) {
            temp += gain[i];
            res = Math.max(res, temp);
        }
        return res;
    }

}
