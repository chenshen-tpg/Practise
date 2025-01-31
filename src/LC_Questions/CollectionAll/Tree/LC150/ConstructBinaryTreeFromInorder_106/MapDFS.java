package LC_Questions.CollectionAll.Tree.LC150.ConstructBinaryTreeFromInorder_106;

import Lib.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MapDFS {
    int preIndex;
    Map<Integer, Integer> hm = new HashMap<>();;

    public static void main(String[] args) {
        MapDFS solution = new MapDFS();
        int [] pre = {3,9,20,15,7};
        int [] in = {9,3,15,20,7};
        solution.build(pre, in);
    }

    public TreeNode build(int [] pre, int [] inorder) {
        preIndex = 0;
        for (int i = 0; i < inorder.length; i++) hm.put(inorder[i], i);
        return helper(pre, 0, pre.length - 1);
    }

    public TreeNode helper (int [] pre, int left, int right) {
        if (left > right) return null;
        int rootVal = pre[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(pre, left, hm.get(rootVal) - 1);
        root.right = helper(pre, hm.get(rootVal) +1 , right);
        return root;
    }

}
