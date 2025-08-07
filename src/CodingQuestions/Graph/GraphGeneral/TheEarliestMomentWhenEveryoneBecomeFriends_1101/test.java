package CodingQuestions.Graph.GraphGeneral.TheEarliestMomentWhenEveryoneBecomeFriends_1101;

import java.util.Arrays;

public class test {
    private int[] par;

    public static void main(String[] args) {

    }
    private int find(int u) {
        if (par[u] != u) par[u] = find(par[u]);
        return par[u];
    }

    private boolean join(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2) return false;
        if (p1 > p2) par[p1] = p2;
        else par[p2] = p1;
        return true;
    }

    public int earliestAcq(int[][] logs, int n) {
        par = new int[n];
        for (int i = 0; i < n; i++) par[i] = i;
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] log : logs) {
            if (join(log[1], log[2])) n--;
            if (n == 1) return log[0];
        }
        return -1;
    }
}
