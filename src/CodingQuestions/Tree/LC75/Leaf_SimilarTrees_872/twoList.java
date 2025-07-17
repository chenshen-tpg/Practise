package CodingQuestions.Tree.LC75.Leaf_SimilarTrees_872;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class twoList {

    public static void main(String[] args) {
        twoList d = new twoList();
        TreeNode treeNode1 = new TreeNode();
        TreeNode treeNode2 = new TreeNode();
        d.dfs(treeNode1, treeNode2);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
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
