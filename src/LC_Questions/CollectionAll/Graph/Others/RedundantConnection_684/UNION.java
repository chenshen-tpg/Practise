package LC_Questions.CollectionAll.Graph.Others.RedundantConnection_684;

public class UNION {
    public static void main(String[] args) {
        int [][] edges = {{1, 2}, {1, 3}, {2, 3}};
        /***
         *  0-1 0-2 1-1 1-3 2-2 2-3
         */
    }
    public int[] findRedundantConnection(int[][] edges) {
        par = new int[edges.length+1];
        for (int i = 0; i < par.length; i++)
            par[i] = i;
        for (int[] e : edges)
            if (find(e[0]) == find(e[1])) return e;
            else union(e[0],e[1]);
        return edges[0];
    }
    private int[] par;
    private int find(int x) {
        if (x != par[x]) par[x] = find(par[x]);
        return par[x];
    }
    private void union(int x, int y) {
        par[find(y)] = find(x);
    }
}
