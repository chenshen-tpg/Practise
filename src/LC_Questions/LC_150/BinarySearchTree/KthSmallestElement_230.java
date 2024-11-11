package LC_Questions.LC_150.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement_230 {
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

    public static void main(String[] args) {
        KthSmallestElement_230 kse = new KthSmallestElement_230();
        TreeNode root = kse.new TreeNode(3);
        root.left = kse.new TreeNode(1);
        root.right = kse.new TreeNode(4);
        root.left.right = kse.new TreeNode(2);
        System.out.println(kse.kthSmallest(root, 1));
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = helper(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
    public List<Integer> helper(TreeNode root, List<Integer> arr) {
        if (root == null) return arr;
        helper(root.left, arr);
        arr.add(root.val);
        helper(root.right, arr);
        return arr;
    }
}
