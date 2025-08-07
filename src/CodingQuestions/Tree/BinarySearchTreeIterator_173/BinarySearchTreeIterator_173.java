package CodingQuestions.Tree.BinarySearchTreeIterator_173;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator_173 {

    List<Integer> li;
    int index;

    public static void main(String[] args) {
        BinarySearchTreeIterator_173 bst = new BinarySearchTreeIterator_173();
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
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
