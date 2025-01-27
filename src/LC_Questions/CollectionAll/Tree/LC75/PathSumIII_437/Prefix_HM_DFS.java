package LC_Questions.CollectionAll.Tree.LC75.PathSumIII_437;

import Lib.TreeNode;

import java.util.HashMap;

public class Prefix_HM_DFS {
    int count = 0;
    int k;
    HashMap<Long, Integer> h = new HashMap();

    public static void main(String[] args) {
        Prefix_HM_DFS d = new Prefix_HM_DFS();
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
        System.out.println(d.pathSum(root1, targetSum1));
    }
    public void preorder(TreeNode node, long currSum) {
        if (node == null) return;
        currSum += node.val;
        if (currSum == k) count++;
        count += h.getOrDefault(currSum - k, 0);
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        preorder(node.left, currSum);
        preorder(node.right, currSum);
        h.put(currSum, h.get(currSum) - 1);
    }

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0L);
        return count;
    }
}
