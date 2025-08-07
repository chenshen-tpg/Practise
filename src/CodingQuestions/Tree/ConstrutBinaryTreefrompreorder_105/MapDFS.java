package CodingQuestions.Tree.ConstrutBinaryTreefrompreorder_105;

import CodingQuestions.Lib.TreeNode;

import java.util.HashMap;

public class MapDFS {
    int postIndex;
    HashMap<Integer, Integer> hm = new HashMap();

    public static void main(String[] args) {
        MapDFS solution = new MapDFS();
        int [] in = {9,3,15,20,7};
        int [] post = {9,15,7,20,3};
        solution.buildTree(post, in);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) hm.put(inorder[i], i);
        return helper(postorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, hm.get(rootVal) + 1, right);
        root.left = helper(postorder, left, hm.get(rootVal) - 1);
        return root;
    }

}
