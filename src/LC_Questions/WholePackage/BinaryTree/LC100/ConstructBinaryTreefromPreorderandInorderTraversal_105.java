package LC_Questions.WholePackage.BinaryTree.LC100;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
    public int preIndex;
    public Map<Integer,Integer> map;
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
        ConstructBinaryTreefromPreorderandInorderTraversal_105 cb = new ConstructBinaryTreefromPreorderandInorderTraversal_105();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = cb.buildTree(preorder, inorder);
        while(root != null) {
            System.out.println(root.val);
            root = root.left;
        }
    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        preIndex = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    public TreeNode helper(int [] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, left, map.get(rootVal) - 1);
        root.right = helper(preorder, map.get(rootVal) + 1, right);
        return root;
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
