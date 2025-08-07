package CodingQuestions.Tree.LowestCommonAncestorofaBinaryTree_236;


import CodingQuestions.Lib.TreeNode;

public class DFS {

    public static void main(String[] args) {

    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}


