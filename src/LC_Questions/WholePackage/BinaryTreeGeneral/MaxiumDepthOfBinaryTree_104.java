package LC_Questions.WholePackage.BinaryTreeGeneral;

public class MaxiumDepthOfBinaryTree_104 {
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
        MaxiumDepthOfBinaryTree_104 md = new MaxiumDepthOfBinaryTree_104();
        TreeNode root = md.new TreeNode(3);
        TreeNode n1 = md.new TreeNode(9);
        TreeNode n2 = md.new TreeNode(20);
        TreeNode n3 = md.new TreeNode(15);
        TreeNode n4 = md.new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        System.out.println(md.maxDepth(root));
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
