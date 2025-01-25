package LC_Questions.WholePackage.Tree.LC100.ConstructBinaryTreefromPreorderandInorderTraversal_105;

import Lib.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MapDFS {
    public int preIndex;
    public Map<Integer,Integer> map;

    public static void main(String[] args) {
        MapDFS cb = new MapDFS();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = cb.mapDFS(preorder, inorder);
        while(root != null) {
            System.out.println(root.val);
            root = root.left;
        }
    }
    public TreeNode mapDFS(int[] preorder, int[] inorder) {
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
}
