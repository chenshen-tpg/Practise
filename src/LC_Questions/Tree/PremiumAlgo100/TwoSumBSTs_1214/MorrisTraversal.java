package LC_Questions.Tree.PremiumAlgo100.TwoSumBSTs_1214;

import Lib.TreeNode;

public class MorrisTraversal {


    void morrisTraversal(TreeNode node) {
        TreeNode current = node;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
