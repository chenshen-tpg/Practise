package LC_Questions.Array.BackTracking.Others.ConstructLexicographicallyLargestValidSequence_1718;

public class test {
    boolean[] visited;

    public static void main(String[] args) {

    }
    public int[] constructDistancedSequence(int n) {
        visited = new boolean[n + 1];
        int[] ans = new int[n * 2 - 1];
        helper(0, ans, n);
        return ans;
    }

    private boolean helper(int index, int[] ans, int n) {
        if (index == ans.length) return true;
        if (ans[index] != 0) return helper(index + 1, ans, n);
        else {
            for (int i = n; i >= 1; i--) {
                if (visited[i]) continue;
                visited[i] = true;
                ans[index] = i;
                if (i == 1) {
                    if (helper(index + 1, ans, n)) return true;
                } else if (index + i < ans.length && ans[index + i] == 0) {
                    ans[i + index] = i;
                    if (helper(index + 1, ans, n)) return true;
                    ans[index + i] = 0;
                }
                ans[index] = 0;
                visited[i] = false;
            }

        }
        return false;
    }
}
