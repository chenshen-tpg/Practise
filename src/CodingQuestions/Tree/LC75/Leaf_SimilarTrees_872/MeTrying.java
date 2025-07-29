package CodingQuestions.Tree.LC75.Leaf_SimilarTrees_872;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MeTrying {
    public static void main(String[] args) {

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> li1 = new ArrayList();
        List<Integer> li2 = new ArrayList();
        helper(li1, root1);
        helper(li2, root2);
        return li1.equals(li2);
    }
    public void helper (List<Integer> li, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            li.add(root.val);
        }
        helper(li, root.left);
        helper(li, root.right);
    }
}
