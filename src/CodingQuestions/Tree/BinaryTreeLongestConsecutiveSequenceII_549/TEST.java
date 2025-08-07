package CodingQuestions.Tree.BinaryTreeLongestConsecutiveSequenceII_549;

import CodingQuestions.Lib.TreeNode;

public class TEST {
    private int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        maxLen = 0;
        helper(root, null, new int[]{1,1});
        return maxLen;
    }

    public void helper(TreeNode child, TreeNode parent, int[] parentLens) {
        if (child == null) return;
        int[] childLen = new int[]{1,1};
        helper(child.left, child, childLen);
        helper(child.right, child, childLen);
        if (parent != null) {
            if (child.val + 1 == parent.val) parentLens[0] = Math.max(parentLens[0], childLen[0] + 1);
            else if (child.val == parent.val + 1) parentLens[1] = Math.max(parentLens[1], childLen[1] + 1);
        }
        maxLen = Math.max(maxLen, parentLens[0] + parentLens[1] - 1);
    }
}
