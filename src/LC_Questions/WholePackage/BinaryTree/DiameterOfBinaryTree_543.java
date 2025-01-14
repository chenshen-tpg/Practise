package LC_Questions.WholePackage.BinaryTree;

public class DiameterOfBinaryTree_543 {
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
