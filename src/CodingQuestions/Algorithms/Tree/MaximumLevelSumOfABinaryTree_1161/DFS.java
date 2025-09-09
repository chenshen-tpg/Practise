package CodingQuestions.Algorithms.Tree.MaximumLevelSumOfABinaryTree_1161;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        DFS solution = new DFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(solution.maxLevelSum(root));
    }

    private int maxLevelSum(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        helper(root, 0, al);
        int max = Integer.MIN_VALUE;
        int layer = 0;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) > max) {
                max = al.get(i);
                layer = i + 1;
            }
        }
        return layer;
    }
    public void helper (TreeNode node, int layer, List<Integer> li) {
        if (node == null) return;

        if (li.size() == layer) {
            li.add(node.val);
        } else {
            li.set(layer, li.get(layer) + node.val);
        }
        helper(node.left, layer + 1, li);
        helper(node.right, layer + 1, li);
    }
}
