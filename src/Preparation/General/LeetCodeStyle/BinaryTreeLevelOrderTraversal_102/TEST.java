package Preparation.General.LeetCodeStyle.BinaryTreeLevelOrderTraversal_102;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TEST {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> li = new ArrayList();
        if (root == null) return li;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            li.add(new ArrayList());
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                li.get(level).add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            level++;
        }
        return li;
    }
}
