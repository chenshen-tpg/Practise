package CodingQuestions.Algorithms.Tree.SymmetricTree_101;

import CodingQuestions.Lib.TreeNode;

public class DFS {
    public static void main(String[] args) {
        DFS solution = new DFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return helper(left, right);
    }
    public boolean helper (TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (right == null || left == null) return false;
        if (left.val != right.val) return false;
//        helper(left.left, right.right);
//        helper(left.right,right.left);
//        return true;
        return helper(left.left, right.right) &&  helper(left.right,right.left) ;
    }
}
