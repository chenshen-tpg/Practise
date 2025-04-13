package LC_Questions.Array.ArrayGeneral.LC150.Hindex_274;

public class Counting {

    public static void main(String[] args) {
        Counting solution = new Counting();
        solution.hIndex(new int [] {3,0,6,1,5});
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        for (int c: citations) {
            papers[Math.min(n, c)]++;
        }
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k]) k--;
        return k;
    }
}
