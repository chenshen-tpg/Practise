package CodingQuestions.Algorithms.Tree.TwoSumBSTs_1214;

import CodingQuestions.Lib.TreeNode;

public class BinarySearch {
    public static void main(String[] args) {

    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return dfs(root1,root2,target);
    }
    boolean dfs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) return false;
        if (bs(root2, target - root1.val)) return true;
        else return dfs(root1.left, root2, target) || dfs(root1.right, root2, target);
    }
    boolean bs (TreeNode root2, int target) {
        if (root2 == null) return false;
        if (root2.val == target) return true;
        else if (root2.val > target) return bs(root2.left, target);
        else return bs(root2.right, target);
    }
}
