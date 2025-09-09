package CodingQuestions.Algorithms.Tree.BinaryTreeZigZagLevelOrderTravel_103;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal_103 {


    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal_103 bt = new BinaryTreeZigzagLevelOrderTraversal_103();
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        List<List<Integer>> ans = bt.zigzagLevelOrder(root);
        for (int i = 1; i < ans.size(); i += 2) {
            Collections.reverse(ans.get(i));
        }
        System.out.println(ans);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> li = new ArrayList<>();
        if (root == null) return li;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size;i++) {
                TreeNode cur = q.remove();
                layer.add(cur.val);
                if (cur.left != null) {q.add(cur.left);}
                if (cur.right != null) {q.add(cur.right);}
            }
           Collections.reverse(layer);
        }
        return li;
    }
    public List<List<Integer>> ques(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
}
