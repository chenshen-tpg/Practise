package LC_Questions.WholePackage.Tree.LC75.MaxiumDepthOfBinaryTree_104;

import Lib.TreeNode;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

public class TailRecursionBFS {

    private Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> next_items = new LinkedList<>();
    private int max_depth = 0;

    public static void main(String[] args) {

    }

    private int next_maxDepth() {
        if (next_items.isEmpty()) {
            return max_depth;
        }
        AbstractMap.SimpleEntry<TreeNode, Integer> next_item = next_items.poll();
        TreeNode next_node = next_item.getKey();
        int next_level = next_item.getValue() + 1;
        max_depth = Math.max(max_depth, next_level);
        if (next_node.left != null) {
            next_items.add(new AbstractMap.SimpleEntry<>(next_node.left, next_level));
        }
        if (next_node.right != null) {
            next_items.add(new AbstractMap.SimpleEntry<>(next_node.right, next_level));
        }
        return next_maxDepth();
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        next_items.clear();
        max_depth = 0;
        next_items.add(new AbstractMap.SimpleEntry<>(root, 0));
        return next_maxDepth();
    }
}
