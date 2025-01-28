package LC_Questions.CollectionAll.Tree.LC75.BinaryTreeRightSightView_199;

import Lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {


    private List<Integer> BFS(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (i == size - 1) {
                    res.add(temp.val);
                }
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right !=null) {
                    q.offer(temp.right);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        BFS solution = new BFS();
        List<Integer> showing = solution.BFS(root1);
        for (int i = 0; i < showing.size(); i++) {
            System.out.print(showing.get(i) + " ");
        }
    }
}
