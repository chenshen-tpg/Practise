package CodingQuestions.Array.ArrayGeneral.Others.MinimumDominoRotation_1007;

public class TEST {
    public static void main(String[] args) {

    }

    public int minDominoRotations(int[] A, int[] B) {
        if (check(A[0], B, A,  A.length) != -1 || A[0] == B[0]) return check(A[0], B, A,  A.length);
        else return check(B[0], B, A, A.length);
    }

    public int check(int x, int[] A, int[] B, int n) {
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x) return -1;
            else if (A[i] != x) a++;
            else if (B[i] != x) b++;
        }
        return Math.min(a, b);
    }
}
