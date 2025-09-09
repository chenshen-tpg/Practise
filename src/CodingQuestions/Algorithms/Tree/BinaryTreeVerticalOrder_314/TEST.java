package CodingQuestions.Algorithms.Tree.BinaryTreeVerticalOrder_314;

import CodingQuestions.Lib.Pair;
import CodingQuestions.Lib.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TEST {
    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null)
            return output;
        Map<Integer, ArrayList> hm = new HashMap();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        int column = 0;
        queue.offer(new Pair(root, column));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!hm.containsKey(column)) {
                    hm.put(column, new ArrayList<Integer>());
                }
                hm.get(column).add(root.val);
                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
            }
        }
        List<Integer> sortedKeys = new ArrayList<Integer>(hm.keySet());
        Collections.sort(sortedKeys);
        for (int k : sortedKeys) {
            output.add(hm.get(k));
        }
        return output;
    }
}
