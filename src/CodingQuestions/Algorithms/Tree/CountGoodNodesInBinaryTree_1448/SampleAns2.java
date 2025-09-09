package CodingQuestions.Algorithms.Tree.CountGoodNodesInBinaryTree_1448;

import CodingQuestions.Lib.TreeNode;

public class SampleAns2 {
    public static void main(String[] args) {

    }
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return helper(root, root.val);
    }
    public int helper (TreeNode root, int cur) {
        if (root == null) return 0;
        int res = 0;
        if (root.val >= cur) {
            res++;
            cur = root.val;
        }
        return helper(root.left, cur) + helper(root.right, cur) + res;
    }
}
