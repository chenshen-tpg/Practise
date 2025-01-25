package LC_Questions.WholePackage.Tree.LC100;

import java.util.ArrayList;
import java.util.List;
import Lib.TreeNode;
public class KthSmallestElement_230 {


    public static void main(String[] args) {
        KthSmallestElement_230 kse = new KthSmallestElement_230();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
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
