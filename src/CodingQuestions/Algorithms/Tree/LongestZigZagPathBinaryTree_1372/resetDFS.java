package CodingQuestions.Algorithms.Tree.LongestZigZagPathBinaryTree_1372;

import CodingQuestions.Lib.TreeNode;

public class resetDFS {
    int path = 0;

    public int method (TreeNode node) {
        dfs(node, 0 ,0);
        return path;
    }
    void dfs (TreeNode node, int left, int right) {
        if (node == null) return;
        path = Math.max(path, Math.max(left, right));
        if (node.right != null) dfs(node.left, right++, 0);
        if (node.left !=null) dfs(node.right,0,left++);
    }

    public static void main(String[] args) {

    }
}
