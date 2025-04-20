package LC_Questions.Tree.PremiumAlgo100.ClosetBSTValue_270;

import Lib.TreeNode;

public class SingleFunction {
    public static void main(String[] args) {

    }

    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target)
                    || (Math.abs(val - target) == Math.abs(closest - target) && val < closest) ? val : closest;
            root =  target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
