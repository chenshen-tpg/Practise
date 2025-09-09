package CodingQuestions.Algorithms.Tree.MaximumLevelSumOfABinaryTree_1161;

import CodingQuestions.Lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(maxLevelSum(root));
    }

    private static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int curMax = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                curMax += cur.val;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            level++;
            if (curMax > max) {
                max = curMax;
                ans = level;
            }
        }
        return ans;
    }
}
