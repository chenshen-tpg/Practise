package LC_Questions.LC_150.BinaryTreeGeneral;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator_173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> li;
    int index;

    public static void main(String[] args) {
        BinarySearchTreeIterator_173 bst = new BinarySearchTreeIterator_173();
        TreeNode root = bst.new TreeNode(7);
        root.left = bst.new TreeNode(3);
        root.right = bst.new TreeNode(15);
        root.right.left = bst.new TreeNode(9);
        root.right.right = bst.new TreeNode(20);
        bst.li = new ArrayList<>();
        bst.index = 0;
        bst.helper(root);
        while(bst.hasNext()) {
            System.out.println(bst.next());
        }
    }

    public int next() {
        return li.get(index++);
    }

    public boolean hasNext() {
        return index + 1 < li.size();
    }
    public void helper(TreeNode root){
        if (root == null) {
            return;
        }
        helper(root.left);
        li.add(root.val);
        helper(root.right);
    }
}
