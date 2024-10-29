package LC_Questions.LC_General.Tree;

import objectInjection.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree_1161 {
    public static void main(String[] args) {

    }
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int max = 0, level = 0, ans = 0;
        q.offer(root);

        while(!q.isEmpty()) {
            int sum = 0;
            level++;
            for (int s = q.size(); s > 0; s--) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left !=null) q.offer(node.left);
                if(node.right !=null) q.offer(node.right);
            }
            if (sum > max){
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}
