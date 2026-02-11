package CodingQuestions.Algorithms.Tree.BalancBinaryTree_110;

import CodingQuestions.Lib.TreeNode;

public class TEST {
//Given a binary tree, determine if it is height-balanced.
// Example 1:
//Input: root = [3,9,20,null,null,15,7]
//Output: true
// Example 2:
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
