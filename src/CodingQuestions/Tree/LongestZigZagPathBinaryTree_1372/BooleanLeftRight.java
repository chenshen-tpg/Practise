package CodingQuestions.Tree.LongestZigZagPathBinaryTree_1372;

import CodingQuestions.Lib.TreeNode;

public class BooleanLeftRight {
    int len = 0;

    public int helper (TreeNode node) {
        dfs(node, false, 0);
        return len;
    }
    public void dfs (TreeNode node, boolean left, int steps) {
        if (node == null) return;
        len = Math.max(len, steps);
        if (left) {
            dfs(node.left, false, steps+1);
            dfs(node.right,true, 1);
        } else {
            dfs(node.left, false, 1);
            dfs(node.right, true, steps+1);
        }
    }
    public static void main(String[] args) {

    }
}
