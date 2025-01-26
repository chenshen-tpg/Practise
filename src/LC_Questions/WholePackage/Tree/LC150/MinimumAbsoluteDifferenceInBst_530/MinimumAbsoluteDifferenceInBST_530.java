package LC_Questions.WholePackage.Tree.LC150.MinimumAbsoluteDifferenceInBst_530;

import Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST_530 {

    TreeNode pre;
    int min = Integer.MAX_VALUE;
    List<Integer> li = new ArrayList<>();
    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST_530 m = new MinimumAbsoluteDifferenceInBST_530();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        root.right = n1;
        n1.left = n2;
        System.out.println(m.getMinimumDifference(root));
    }
    public int getMinimumDifference(TreeNode root) {

        if (root == null){
            return 0;
        }
        getMinimumDifference(root.left);
        li.add(root.val);
        getMinimumDifference(root.right);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < li.size(); i++) {
            min = Math.min(min, li.get(i) - li.get(i-1));
        }
        return min;
    }
    public int getMinimumDifference1(TreeNode root) {
        if (root == null){
            return 0;
        }
        getMinimumDifference(root.left);
        if (pre != null) {
            min = Math.min(min, (root.val - pre.val));
        }
        pre = root;
        getMinimumDifference(root.right);

        return min;
    }
}
