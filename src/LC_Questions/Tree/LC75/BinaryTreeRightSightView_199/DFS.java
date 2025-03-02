package LC_Questions.Tree.LC75.BinaryTreeRightSightView_199;

import Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    List<Integer> rightside = new ArrayList();

    public void helper(TreeNode node, int level) {
        //it's working because its preorder in each layer1
        if (level == rightside.size()) rightside.add(node.val);
        if (node.right != null) helper(node.right, level + 1);
        if (node.left != null) helper(node.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;

        helper(root, 0);
        return rightside;
    }
}
