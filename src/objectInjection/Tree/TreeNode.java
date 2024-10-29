package objectInjection.Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {

    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void adding(ArrayList<String> al) {

    }

    public static void main(String[] args) {
        int[] s = {4, 1, 6, 0, 2, 5, 7, 0, 0, 0, 3, 0, 0, 0, 8};
        int[] indices = {1, 2, 4, 8};

        // Splitting the array based on indices
        int[][] splitArray = splitByIndices(s, indices);

        // Printing the result
        for (int i = 0; i < splitArray.length; i++) {
            System.out.println("Subarray " + (i + 1) + ": " + Arrays.toString(splitArray[i]));
        }
    }

    public static int[][] splitByIndices(int[] s, int[] indices) {
        int[][] result = new int[indices.length][];
        for (int i = 0; i < indices.length; i++) {
            int start = indices[i];
            int end = (i + 1 < indices.length) ? indices[i + 1] : s.length;
            result[i] = Arrays.copyOfRange(s, start, end);
        }
        return result;
    }
}


