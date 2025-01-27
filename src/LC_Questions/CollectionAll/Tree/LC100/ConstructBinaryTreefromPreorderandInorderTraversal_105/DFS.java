package LC_Questions.CollectionAll.Tree.LC100.ConstructBinaryTreefromPreorderandInorderTraversal_105;

import Lib.TreeNode;

public class DFS {


    public static void main(String[] args) {
        DFS cb = new DFS();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = cb.buildTree(preorder, inorder);
        while(root != null) {
            System.out.println(root.val);
            root = root.left;
        }
    }



    private TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
      }
      private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
          if (preStart > preorder.length - 1 || inStart > inEnd) {
              return null;
          }
          TreeNode root = new TreeNode(preorder[preStart]);
          int inIndex = 0;
          for (int i = inStart; i <= inEnd; i++) {
              if (inorder[i] == root.val) {
                  inIndex = i;
              }
          }
          root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
          root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
          return root;
      }
}
