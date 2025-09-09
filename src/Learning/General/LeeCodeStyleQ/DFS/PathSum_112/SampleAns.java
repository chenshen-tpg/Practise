package Learning.General.LeeCodeStyleQ.DFS.PathSum_112;

import CodingQuestions.Lib.TreeNode;

public class SampleAns {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
