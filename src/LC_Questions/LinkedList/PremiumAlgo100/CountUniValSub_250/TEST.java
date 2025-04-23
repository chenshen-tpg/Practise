package LC_Questions.LinkedList.PremiumAlgo100.CountUniValSub_250;

import Lib.TreeNode;

public class TEST {
    int count = 0;

    public static void main(String[] args) {

    }


    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    public boolean helper(TreeNode root) {
        if (root == null)  return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if ((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
                count++;
                return true;
            }
        }
        return false;
    }
}
