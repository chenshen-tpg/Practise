package CodingQuestions.Algorithms.Tree.TwoSumBSTs_1214;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoPointers {
    public static void main(String[] args) {

    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> al1 = new ArrayList(), al2 = new ArrayList();
        dfs(root1, al1);
        dfs(root2, al2);
        int i = 0, j = al2.size() - 1;
        while (i < al1.size() && j >= 0) {
            if (al1.get(i) + al2.get(j) == target) return true;
            else if (al1.get(i) + al2.get(j) < target) i++;
            else j--;
        }
        return false;
    }

    public void dfs(TreeNode root, List<Integer> hs) {
        if (root == null) return;
        dfs(root.left, hs);
        hs.add(root.val);
        dfs(root.right,hs);
    }
}
