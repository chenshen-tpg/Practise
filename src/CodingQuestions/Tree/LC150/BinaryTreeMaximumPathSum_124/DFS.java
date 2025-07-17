package CodingQuestions.Tree.LC150.BinaryTreeMaximumPathSum_124;

import CodingQuestions.Lib.TreeNode;

public class DFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        DFS solution = new DFS();
        System.out.println(solution.maxPathSum(root));
    }
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(dfs(root.left), 0);
        int r = Math.max(dfs(root.right), 0);
        maxSum = Math.max(maxSum, l + r + root.val);
        return Math.max(l + root.val, r + root.val);
    }
}
