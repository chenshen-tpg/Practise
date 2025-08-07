package CodingQuestions.Tree.MaximumLevelSumOfABinaryTree_1161;

import CodingQuestions.Lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Review {
    public static void main(String[] args) {

    }
    public int maxLevelSum(TreeNode root) {
        int count = Integer.MIN_VALUE;
        int ans = 0;
        int layer = 1;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int temp = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                temp += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (temp > count) {
                count = temp;
                ans = layer;
            }
            layer++;
        }
        return ans;
    }
}
