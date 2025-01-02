package LC_Questions.LC_150.BinaryTreeGeneral;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BinaryTreeMaximumPathSum_124 {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum_124.TreeNode root = new BinaryTreeMaximumPathSum_124().new TreeNode(-10);
        root.left = new BinaryTreeMaximumPathSum_124().new TreeNode(9);
        root.right = new BinaryTreeMaximumPathSum_124().new TreeNode(20);
        root.right.left = new BinaryTreeMaximumPathSum_124().new TreeNode(15);
        root.right.right = new BinaryTreeMaximumPathSum_124().new TreeNode(7);
        BinaryTreeMaximumPathSum_124 solution = new BinaryTreeMaximumPathSum_124();
        System.out.println(solution.maxPathSum(root));
    }
    int maxSum = 0;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(dfs(root.left), 0);
        int r = Math.max(dfs(root.right), 0);
        maxSum = Math.max(maxSum, l + r + root.val);
        return Math.max(l + root.val, r + root.val);
    }

    public Iterable<TreeNode> topSort(TreeNode root) {
        Deque<TreeNode> result = new LinkedList<>();
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                result.push(curr);
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
        }
        return result;
    }

    public int maxPathSum_Iteration(TreeNode root) {
        int result = Integer.MIN_VALUE;
        Map<TreeNode, Integer> maxRootPath = new HashMap<>();
        maxRootPath.put(null, 0);
        for (TreeNode node : topSort(root)) {
            int left = Math.max(maxRootPath.get(node.left), 0);
            int right = Math.max(maxRootPath.get(node.right), 0);
            maxRootPath.put(node, Math.max(left, right) + node.val);
            result = Math.max(left + right + node.val, result);
        }
        return result;
    }
}
