package TipsAndSummary.CoreLogicCollection;

public class SUMMARY {
    /*** core of the number extraction logic

     //core of the number extraction logic
     num = num * 10 + s.charAt(i) - '0';



     */


    /***
     // order of binary Search investigation.

     public void helper_inorder(TreeNode child, TreeNode parent, int[] parentLens) {
     if (child == null) return;

     int[] childLen = new int[]{1, 1};

     helper_inorder(child.left, child, childLen); // Process left subtree

     // Process current node (child in this context)
     if (parent != null) {
     if (child.val + 1 == parent.val) parentLens[0] = MatSolution.max(parentLens[0], childLen[0] + 1);
     else if (child.val == parent.val + 1) parentLens[1] = MatSolution.max(parentLens[1], childLen[1] + 1);
     }
     maxLen = MatSolution.max(maxLen, parentLens[0] + parentLens[1] - 1);

     helper_inorder(child.right, child, childLen); // Process right subtree
     }
     */
}
