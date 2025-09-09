package CodingQuestions.Algorithms.Tree.ClosetBSTValue_270;

import CodingQuestions.Lib.TreeNode;

public class StandardBSTSearch {
    int ans;
    double min = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        helper(root, target);
        return ans;
    }
    public void helper (TreeNode root, double target) {
        if (root == null) return;
        double diff = Math.abs(root.val - target);
        if (diff < min) {
            min = diff;
            ans = root.val;
        } else if (diff == min) {
            ans = Math.max(ans, root.val);
        }
        if (target < root.val) helper(root.left, target);
        else helper(root.right, target);
    }
}
