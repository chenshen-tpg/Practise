package CodingQuestions.Algorithms.Tree.AverageOfLevelsInBinaryTree_637;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    /***Given the root of a binary tree, return the average value of the nodes on
     each level in the form of an array. Answers within 10⁻⁵ of the actual answer will
     be accepted.


     Example 1:


     Input: root = [3,9,20,null,null,15,7]
     Output: [3.00000,14.50000,11.00000]
     Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,and on level 2 is 11. Hence return [3, 14.5, 11].
     Example 2:
     Input: root = [3,9,20,15,7]
     Output: [3.00000,14.50000,11.00000]
     ***/
    public static void main(String[] args) {
        BFS al = new BFS();
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
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
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                sum += temp.val;
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            list.add(sum / size);
            sum = 0;
        }
        return list;
    }
}
