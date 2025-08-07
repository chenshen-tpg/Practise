package CodingQuestions.Graph.GraphGeneral.NumberOfProvinces_547;

public class ArrayDFS {
    public static void main(String[] args) {
        ArrayDFS arrayDFS = new ArrayDFS();

        int[][] testCase1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(arrayDFS.findCircleNum(testCase1)); // Expected output: 2

        int[][] testCase2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(arrayDFS.findCircleNum(testCase2)); // Expected output: 3

        int[][] testCase3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println(arrayDFS.findCircleNum(testCase3)); // Expected output: 1

        int[][] testCase4 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(arrayDFS.findCircleNum(testCase4));
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }

    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }
}
