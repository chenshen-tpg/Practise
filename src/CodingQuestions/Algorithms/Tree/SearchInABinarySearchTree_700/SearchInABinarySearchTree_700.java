package CodingQuestions.Algorithms.Tree.SearchInABinarySearchTree_700;

import CodingQuestions.Lib.TreeNode;

public class SearchInABinarySearchTree_700 {


    public static void main(String[] args) {
        SearchInABinarySearchTree_700 solution = new SearchInABinarySearchTree_700();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Value to search for
        int val = 2;
        System.out.println(solution.searchBST(root, val));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
