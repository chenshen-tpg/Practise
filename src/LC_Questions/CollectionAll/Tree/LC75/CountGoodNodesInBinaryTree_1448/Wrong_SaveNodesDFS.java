package LC_Questions.CollectionAll.Tree.LC75.CountGoodNodesInBinaryTree_1448;

import Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Wrong_SaveNodesDFS {
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

    // wrong because we need to keep counting all the node in the director
    // Instead of having the one node.
    public int goodNodes(TreeNode root) {
        int res = 0;
        int judge =  root.val;
        ArrayList<Integer> al = new ArrayList<>();
        helper (root, al);
        for (Integer a : al) if (a >= judge) res++;
        return res;
    }

    public void helper (TreeNode root, List<Integer> rootLen) {
        if (root == null) return;
        helper(root.left, rootLen);
        rootLen.add(root.val);
        helper(root.right, rootLen);
    }
}
