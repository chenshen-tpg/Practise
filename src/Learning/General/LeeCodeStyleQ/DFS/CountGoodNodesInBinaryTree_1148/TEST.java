package Learning.General.LeeCodeStyleQ.DFS.CountGoodNodesInBinaryTree_1148;

import CodingQuestions.Lib.TreeNode;

public class TEST {
    public static void main(String[] args) {

    }
    int sum = 0;
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return sum;
    }
    public void helper(TreeNode head, int val) {
        if (head == null) return;
        if (head.val >= val) {
            val = head.val;
            sum++;
        }
        helper(head.left, val);
        helper(head.right,val);
    }
}
