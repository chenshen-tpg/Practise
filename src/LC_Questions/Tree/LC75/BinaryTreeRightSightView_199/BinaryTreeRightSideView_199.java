package LC_Questions.Tree.LC75.BinaryTreeRightSightView_199;

import Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_199 {
    List<Integer> rightside = new ArrayList();

    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) rightside.add(node.val);

        if (node.right != null) helper(node.right, level + 1);
        if (node.left != null) helper(node.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        helper(root, 0);
        return rightside;
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        BinaryTreeRightSideView_199 solution = new BinaryTreeRightSideView_199();
        solution.rightSideView(root1);
    }
}
