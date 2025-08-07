package CodingQuestions.Tree.BinaryTreeVerticalOrderTraversal_314;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSHM {


    public static void main(String[] args) {
        BFSHM bt = new BFSHM();
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

        List<List<Integer>> result = bt.verticalOrder(root);
        System.out.println(result);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int cord = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(root.val, cord);
        while(!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode cur = q.remove();
                if (cur.left != null) {
                    q.add(cur.left);
                    hm.put(cur.left.val,cord - 1);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    hm.put(cur.right.val,cord + 1);
                }
            }
            cord++;
        }
        return res;
    }
}
