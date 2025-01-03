package LC_Questions.WholePackage.BinaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree_637 {
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

    public static void main(String[] args) {
        AverageofLevelsinBinaryTree_637 al = new AverageofLevelsinBinaryTree_637();
        TreeNode root = al.new TreeNode(3);
        TreeNode n1 = al.new TreeNode(9);
        TreeNode n2 = al.new TreeNode(20);
        TreeNode n3 = al.new TreeNode(15);
        TreeNode n4 = al.new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        System.out.println(al.averageOfLevels(root));
    }
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        q.add(root);
        double sum = 0;
        while (!q.isEmpty()) {
            int size =  q.size();
            for (int i = 0; i < size; i ++) {
                TreeNode temp = q.poll();
                sum += temp.val;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            list.add(sum * 1.0 / size);
            sum = 0;
        }
        return list;
    }
}
