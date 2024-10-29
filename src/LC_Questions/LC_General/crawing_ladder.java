package LC_Questions.LC_General;

public class crawing_ladder {
    public static void main(String[] args) {
        int n = 9;
        int [] len = new int [n+1];
        len[0] = 1;
        len[1] = 2;
        len[2] = 3;
        for (int i = 3; i < n + 1; i++) {
            len[i] = len[i-1] + len[i-2] +len[i-3];
            System.out.println(len[i]);
        }
    }
}
