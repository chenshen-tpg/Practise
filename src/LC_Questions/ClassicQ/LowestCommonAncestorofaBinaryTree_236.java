package LC_Questions.ClassicQ;



public class LowestCommonAncestorofaBinaryTree_236 {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {
            }
            TreeNode(int val) {
                this.val = val;
            }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public static void main(String[] args) {

        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == p || root == q || root == null) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left,p, q);
            TreeNode right = lowestCommonAncestor(root.right, p ,q);
            if (left == null) return right;
            else if (right == null) return left;
            else return root;
        }
}
