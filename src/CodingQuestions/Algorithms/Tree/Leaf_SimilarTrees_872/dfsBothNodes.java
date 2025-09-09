package CodingQuestions.Algorithms.Tree.Leaf_SimilarTrees_872;

import CodingQuestions.Lib.TreeNode;

public class dfsBothNodes {

    public static void main(String[] args) {

    }


    public boolean dfs(TreeNode root1, TreeNode root2) {
        return compareLeaves(root1, root2);
    }

    private boolean compareLeaves(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (isLeaf(node1) && isLeaf(node2)) return node1.val == node2.val;
        if (isLeaf(node1) || isLeaf(node2)) return false;
        return compareLeaves(node1.left, node2.left) && compareLeaves(node1.right, node2.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
