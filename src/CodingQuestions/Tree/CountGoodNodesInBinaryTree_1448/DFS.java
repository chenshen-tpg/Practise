package CodingQuestions.Tree.CountGoodNodesInBinaryTree_1448;

import CodingQuestions.Lib.TreeNode;

public class DFS {


    int res = 0;

    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return res;
    }
    private void helper(TreeNode root, int cur) {
        if (root == null) return;
        if (root.val >= cur) res++;
        helper(root.left, Math.max(cur, root.val));
        helper(root.right, Math.max(cur, root.val));
    }
    public static void main(String[] args) {
        Wrong_SaveNodesDFS solution = new Wrong_SaveNodesDFS();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        System.out.println(solution.goodNodes(root1)); // Output: 3

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println(solution.goodNodes(root2)); // Output: 1

        // Example 3
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(4);
        root3.left.left = new TreeNode(3);
        root3.right.left = new TreeNode(1);
        root3.right.right = new TreeNode(5);
        System.out.println(solution.goodNodes(root3));
    }
}
