package LC_Questions.Tree.LC100.ConvertSortedArrayToBinaryTree_108;

import Lib.TreeNode;

public class DFS {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    public TreeNode helper(int left, int right, int[] nums) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1, nums);
        root.right = helper(mid + 1, right, nums);
        return root;
    }
}
