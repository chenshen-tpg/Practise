package CodingQuestions.Tree.DeleteNodeInBST_450;

import CodingQuestions.Lib.TreeNode;

public class BSTThreeConditions {
    public static void main(String[] args) {
        BSTThreeConditions solution = new BSTThreeConditions();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        // Key to delete
        int key = 3;
        solution.helper(root, key);
    }
    public TreeNode helper (TreeNode root, int key) {
        if(root==null) return null;

        if(key<root.val) {
            root.left = helper(root.left,key);
            return root;
        }

        else if(key>root.val) {
            root.right = helper(root.right,key);
            return root;
        }
        else{
            if(root.left==null) {
                return root.right;
            } else if(root.right==null) {
                return root.left;
            } else {
                //Find the in-order successor (the smallest node in the right subtree)
                TreeNode min = root.right;
                while (min.left != null) min = min.left;
                root.val = min.val;
                root.right = helper(root.right,min.val);
                return root;
            }
        }
    }


}
