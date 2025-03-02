package LC_Questions.Tree.LC150.SameTree_100;

import Lib.TreeNode;

import java.util.ArrayDeque;

public class TwoDequeBFS {

    public static void main(String[] args) {
        TwoDequeBFS st = new TwoDequeBFS();
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        System.out.println(st.twoArrayDeque(root, root));
    }

    public boolean twoArrayDeque(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);
        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();
            if (!check(p, q)) return false;
            if (p != null) {
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }


}
