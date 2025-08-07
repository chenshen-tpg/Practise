package CodingQuestions.Tree.TwoSumBSTs_1214;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BruteForce {
    public static void main(String[] args) {

    }


    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> li1 = new ArrayList(), li2 = new ArrayList();
        helper(root1,li1);
        helper(root2,li2);
        for (int a : li1) {
            for (int b : li2) {
                if (a + b == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public void helper (TreeNode root, List<Integer> li) {
        if (root == null) return;
        li.add(root.val);
        helper(root.left, li);
        helper(root.right, li);
    }
}
