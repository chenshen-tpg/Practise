package LC_Questions.CollectionAll.Tree.LC75.Leaf_SimilarTrees_872;

import Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MeReview {
    public static void main(String[] args) {
        MeReview d = new MeReview();

        // Test Case 1: Identical Leaf Values
        TreeNode tree1Case1 = new TreeNode(3);
        tree1Case1.left = new TreeNode(5);
        tree1Case1.right = new TreeNode(1);
        tree1Case1.left.left = new TreeNode(6);
        tree1Case1.left.right = new TreeNode(2);
        tree1Case1.left.right.left = new TreeNode(7);
        tree1Case1.left.right.right = new TreeNode(4);
        tree1Case1.right.left = new TreeNode(9);
        tree1Case1.right.right = new TreeNode(8);

        TreeNode tree2Case1 = new TreeNode(3);
        tree2Case1.left = new TreeNode(5);
        tree2Case1.right = new TreeNode(1);
        tree2Case1.left.left = new TreeNode(6);
        tree2Case1.left.right = new TreeNode(2);
        tree2Case1.left.right.left = new TreeNode(7);
        tree2Case1.left.right.right = new TreeNode(4);
        tree2Case1.right.left = new TreeNode(9);
        tree2Case1.right.right = new TreeNode(8);
        System.out.println("Test Case 1: " + d.leafSimilar(tree1Case1, tree2Case1));
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = helper(root1, new ArrayList<>());
        List<Integer> r2 = helper(root2, new ArrayList<>());
        return r1.equals(r2);
    }
    public List<Integer> helper (TreeNode node, ArrayList<Integer> al) {
        if (node == null) return al;
        if (node.left == null && node.right == null) {
            al.add(node.val);
        }
        helper(node.left, al);
        helper(node.right, al);
        return al;
    }
}
