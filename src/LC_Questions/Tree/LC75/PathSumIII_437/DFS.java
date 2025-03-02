package LC_Questions.Tree.LC75.PathSumIII_437;

import Lib.TreeNode;

import java.util.HashMap;

public class DFS {
    public static void main(String[] args) {
        TreeNode treenode = new TreeNode();
        int targetSum = 8;
        DFS d = new DFS();
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        root1.right.right = new TreeNode(11);
        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);
        root1.left.right.right = new TreeNode(1);
        int targetSum1 = 8;
        System.out.println(d.helper(root1, targetSum1));

        d.helper(treenode, targetSum);
    }

    int sum;
    int count ;
    HashMap<Long, Integer> h = new HashMap();

    public int helper(TreeNode root, int targetSum) {
        sum = targetSum;
        dfs (root, 0);
        return count;
    }

    public void dfs (TreeNode root, long current) {
        if (root == null) return;
        current += root.val;
        if (current == sum) count++;
        count += h.getOrDefault(current - sum,0);
        h.put(current, h.getOrDefault(current, 0) + 1);
        dfs(root.left, current);
        dfs(root.right, current);
        h.put(current, h.get(current) - 1);
    }
}
