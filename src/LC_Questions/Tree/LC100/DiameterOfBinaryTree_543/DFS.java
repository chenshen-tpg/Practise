package LC_Questions.Tree.LC100.DiameterOfBinaryTree_543;
import Lib.ListNode;
import Lib.TreeNode;

import java.util.ArrayList;

public class DFS {

        int dia = 0;
        ArrayList<TreeNode> leftNode = new ArrayList<>();
        ArrayList<TreeNode> rightNode = new ArrayList<>();

    public static void main(String[] args) {

    }
        public int diameterOfBinaryTree(TreeNode root) {
            helper(root);
            return dia;
        }

        public int helper (TreeNode cur) {
            if (cur == null) return 0;
            int left = helper(cur.left);
            int right = helper(cur.right);
            leftNode.add(cur.left);
            rightNode.add(cur.right);
            dia = Math.max(dia, left + right);
            return Math.max(left, right) + 1;
        }

}
