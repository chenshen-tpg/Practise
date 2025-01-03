package LC_Questions.WholePackage.BinaryTreeGeneral;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST_530 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    TreeNode pre;
    int min = Integer.MAX_VALUE;
    List<Integer> li = new ArrayList<>();
    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST_530 m = new MinimumAbsoluteDifferenceInBST_530();
        TreeNode root = m.new TreeNode(1);
        TreeNode n1 = m.new TreeNode(3);
        TreeNode n2 = m.new TreeNode(2);
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
