package LC_Questions.WholePackage.Tree.LC100;
import Lib.TreeNode;

public class DiameterOfBinaryTree_543 {

        int dia = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            helper(root);
            return dia;
        }

        public int helper (TreeNode cur) {
            if (cur == null) return 0;
            int left = helper(cur.left);
            int right = helper(cur.right);
            dia = Math.max(dia, left + right);
            return Math.max(left, right) + 1;
        }

}
