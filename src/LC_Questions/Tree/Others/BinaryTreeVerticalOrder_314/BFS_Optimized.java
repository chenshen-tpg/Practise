package LC_Questions.Tree.Others.BinaryTreeVerticalOrder_314;

import Lib.Pair;
import Lib.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS_Optimized {
    public static void main(String[] args) {

    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList> columnTable = new HashMap();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        int column = 0;
        queue.offer(new Pair(root, column));
        int minColumn = 0, maxColumn = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();
            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);
                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
            }
        }
        for(int i = minColumn; i < maxColumn + 1; ++i) {
            output.add(columnTable.get(i));
        }
        return output;
    }
}
