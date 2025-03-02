package LC_Questions.Tree.Others;

import Lib.Pair;
import Lib.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal_314 {


    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal_314 bt = new BinaryTreeVerticalOrderTraversal_314();
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
        hm.put(root.val,cord);
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
    public List<List<Integer>> verticalOrder_ModelAnswer(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList> columnTable = new HashMap();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        int column = 0;
        queue.offer(new Pair(root, column));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.val);

                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
            }
        }

        List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
        Collections.sort(sortedKeys);
        for(int k : sortedKeys) {
            output.add(columnTable.get(k));
        }

        return output;
    }
}
