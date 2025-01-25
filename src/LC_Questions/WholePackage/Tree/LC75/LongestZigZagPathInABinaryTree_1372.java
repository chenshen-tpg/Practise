package LC_Questions.WholePackage.Tree.LC75;

import Lib.TreeNode;

public class LongestZigZagPathInABinaryTree_1372 {

    public static void main(String[] args) {

    }
    int path = 0;
    public int longestZigZag(TreeNode root) {
        helper(root, 0, 0);
        return path;
    }
    public void helper(TreeNode root, int left, int right) {
        if (root == null) return;
        path = Math.max(path, Math.max(left, right));
        if (root.left != null) helper(root.left, right + 1, 0);
        if (root.right != null) helper(root.right, 0, left + 1);
    }
}
