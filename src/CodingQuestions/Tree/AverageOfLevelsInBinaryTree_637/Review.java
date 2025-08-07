package CodingQuestions.Tree.AverageOfLevelsInBinaryTree_637;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Review {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        Review review = new Review();
        System.out.println(review.solution(root));
    }

    public List<Double> solution(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double tempVal = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = q.poll();
                tempVal += tempNode.val;
                if (tempNode.left != null) q.offer(tempNode.left);
                if (tempNode.right != null) q.offer(tempNode.right);
            }
            res.add(tempVal / size);
        }
        return res;
     }
}
