package LC_Questions.CollectionAll.Tree.Others.ConstructBinaryTreeFromPreandPost_889;

import Lib.TreeNode;

import java.util.HashMap;

public class MapRecursive {
    int index = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        MapRecursive solution = new MapRecursive();
        solution.constructFromPrePost(new int [] {1, 2, 4, 5, 3, 6, 7}, new int [] {4, 5, 2, 6, 7, 3, 1});
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for (int i = 0; i < post.length; i++) hm.put(post[i], i);
        return helper(pre, post, 0, post.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] postorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        if (start == end) return root;
        int cur = hm.get(preorder[index]);
        root.left = helper(preorder, postorder, start, cur);
        root.right = helper(preorder, postorder, cur + 1, end - 1);
        return root;
    }
}
