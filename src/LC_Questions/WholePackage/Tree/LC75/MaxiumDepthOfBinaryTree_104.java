package LC_Questions.WholePackage.Tree.LC75;
import Lib.TreeNode;

public class MaxiumDepthOfBinaryTree_104 {

    public static void main(String[] args) {
        MaxiumDepthOfBinaryTree_104 md = new MaxiumDepthOfBinaryTree_104();
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
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
