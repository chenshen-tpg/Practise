package CodingQuestions.Tree.InvertBinaryTree_226;

import CodingQuestions.Lib.TreeNode;

public class TEST {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        while(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
