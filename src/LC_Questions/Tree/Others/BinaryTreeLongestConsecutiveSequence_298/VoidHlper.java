package LC_Questions.Tree.Others.BinaryTreeLongestConsecutiveSequence_298;

import Lib.TreeNode;

public class VoidHlper {
    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root,0, root.val);
        return ans;
    }
    public void helper(TreeNode root, int cur, int target) {
        if (root == null) return;
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
        if (root.val == target) cur++;
        else cur = 1;
        ans = Math.max(ans, cur);
    }
}
