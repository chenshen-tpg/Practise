package CodingQuestions.Tree.LC150.InvertBinaryTree_226;


import CodingQuestions.Lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFSQueueReverse {
    public static void main(String[] args) {
        BFSQueueReverse st = new BFSQueueReverse();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left !=null) q.add(cur.left);
                if (cur.right !=null) q.add(cur.right);
            }
        }
        return root;
    }
}
