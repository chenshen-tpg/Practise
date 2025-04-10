package LC_Questions.Tree.Others.BinaryTreeLongestConsecutiveSequence_298;

import Lib.TreeNode;

public class DFS {
    private int maxLength = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return maxLength;
    }
    private void dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) return;
        if (parent != null && p.val == parent.val + 1) length = length + 1;
        else length = 1;
        maxLength = Math.max(maxLength, length);
        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }
}
