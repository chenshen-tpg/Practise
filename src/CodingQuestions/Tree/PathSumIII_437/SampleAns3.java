package CodingQuestions.Tree.PathSumIII_437;

import CodingQuestions.Lib.TreeNode;

public class SampleAns3 {
    public static void main(String[] args) {

    }

    int helper(TreeNode root, long targetSum) {
        if (root == null) return 0;
        int count = 0;
        if (root.val == targetSum)  count = 1;
        count += helper(root.left, targetSum - root.val);
        count += helper(root.right, targetSum - root.val);
        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return helper(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
}
