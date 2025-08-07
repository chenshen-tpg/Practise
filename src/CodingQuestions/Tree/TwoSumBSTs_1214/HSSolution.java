package CodingQuestions.Tree.TwoSumBSTs_1214;

import CodingQuestions.Lib.TreeNode;

import java.util.HashSet;

public class HSSolution {
    public static void main(String[] args) {

    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> hs1 = new HashSet(), hs2 = new HashSet();
        dfs(root1, hs1);
        dfs(root2, hs2);
        for (Integer hs : hs1) {
            if (hs2.contains(target - hs)) return true;
        }
        return false;
    }

    public void dfs(TreeNode root, HashSet<Integer> hs) {
        if (root == null) return;
        dfs(root.left, hs);
        hs.add(root.val);
        dfs(root.right,hs);
    }
}
