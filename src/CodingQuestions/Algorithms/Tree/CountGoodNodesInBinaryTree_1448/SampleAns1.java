package CodingQuestions.Algorithms.Tree.CountGoodNodesInBinaryTree_1448;

import CodingQuestions.Lib.TreeNode;

public class SampleAns1 {
    public static void main(String[] args) {

    }
    int count = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }
    public void helper (TreeNode root, int cur) {
        if (root == null) return;
        if (root.val >= cur) count++;
        helper(root.left, Math.max(cur, root.val));
        helper(root.right, Math.max(cur, root.val));
    }
}
