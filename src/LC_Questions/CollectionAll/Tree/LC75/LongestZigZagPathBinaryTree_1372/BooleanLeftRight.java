package LC_Questions.CollectionAll.Tree.LC75.LongestZigZagPathBinaryTree_1372;

import Lib.TreeNode;

public class BooleanLeftRight {
    int len = 0;
    public static void main(String[] args) {

    }
    public int helper (TreeNode node) {
        dfs(node, false, 0);
        return len;
    }
    public void dfs (TreeNode node, boolean left, int steps) {
        if (node == null) return;
        len = Math.max(len, steps);
        if (left) {
            dfs(node.left, false, steps++);
            dfs(node.right,true, 1);
        } else {
            dfs(node.left, false, 1);
            dfs(node.right, true, steps++);
        }
    }
}
