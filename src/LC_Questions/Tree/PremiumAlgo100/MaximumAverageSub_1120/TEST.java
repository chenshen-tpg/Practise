package LC_Questions.Tree.PremiumAlgo100.MaximumAverageSub_1120;

import Lib.TreeNode;

public class TEST {
    double res = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return res;
    }
    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int [] left = helper(root.left), right = helper(root.right);
        int sum  = left[0] + right[0] + root.val, count = left[1] + right[1] + 1;
        res = Math.max(res, 1.0 * sum / count);
        return new int[]{sum, count};
    }
}
