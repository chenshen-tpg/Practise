package Learning.General.LeeCodeStyleQ.DFS.BinaryTreeTilt_563;

import CodingQuestions.Lib.TreeNode;

public class TEST {
    public static void main(String[] args) {

    }
    int sum = 0;
    public int goodNodes(TreeNode root) {
        dfs(root);
        return sum;
    }
    public int dfs(TreeNode head) {
        if (head == null) return 0;

        int left = dfs(head.left);
        int right = dfs(head.right);
        int tilt = Math.abs(left - right);
        sum += tilt;
        return left + right + head.val;
    }
}
