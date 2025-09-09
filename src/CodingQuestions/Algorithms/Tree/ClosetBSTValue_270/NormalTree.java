package CodingQuestions.Algorithms.Tree.ClosetBSTValue_270;

import CodingQuestions.Lib.TreeNode;

public class NormalTree {

        double min_diff = Double.MAX_VALUE;
        int closest_value = -1;

        public int closestValue(TreeNode root, double target) {
            if (root == null) return -1;
            traverse(root, target);
            return closest_value;
        }

        private void traverse(TreeNode node, double target) {
            if (node == null) return;

            double diff = Math.abs(node.val - target);
            if (diff < min_diff) {
                min_diff = diff;
                closest_value = node.val;
            }

            traverse(node.left, target);
            traverse(node.right, target);
        }

}
