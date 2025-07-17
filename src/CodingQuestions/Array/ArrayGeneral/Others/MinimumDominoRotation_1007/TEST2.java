package CodingQuestions.Array.ArrayGeneral.Others.MinimumDominoRotation_1007;

public class TEST2 {
    public static void main(String[] args) {

    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, res = Integer.MAX_VALUE;
        int[] face = new int[7];
        //don't need to find them all
        for (int i = 0; i < n; i++) {
            face[tops[i]]++;
            if (bottoms[i] != tops[i]) face[bottoms[i]]++;
        }
        for (int j = 1; j < 7; j++) {
            if (face[j] < n) continue;
            int top = 0, bot = 0;
            for (int i = 0; i < n; i++) {
                if (tops[i] != j) top++;
                if (bottoms[i] != j) bot++;
            }
            res = Math.min(res, Math.min(top, bot));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
