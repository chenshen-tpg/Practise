package Learning.General.LeeCodeStyleQ.DFS.DiameterOfBinaryTree_543;

import CodingQuestions.Lib.TreeNode;

public class TEST {
    public static void main(String[] args) {

    }

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs (TreeNode cur) {
        int left = dfs(cur.left);
        int right = dfs(cur.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
