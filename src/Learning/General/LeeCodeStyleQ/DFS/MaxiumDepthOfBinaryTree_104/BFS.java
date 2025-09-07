package Learning.General.LeeCodeStyleQ.DFS.MaxiumDepthOfBinaryTree_104;

import CodingQuestions.Lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }
}
