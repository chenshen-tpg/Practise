package LC_Questions.WholePackage.BinaryTreeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                Node tem = q.poll();
                if (i < size - 1){
                    tem.next = q.peek();
                }
                if (tem.left !=null){
                    q.add(tem.left);
                }
                if (tem.right !=null){
                    q.add(tem.left);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII p = new PopulatingNextRightPointersInEachNodeII();
        Node root = p.new Node(1);
        Node n1 = p.new Node(2);
        Node n2 = p.new Node(3);
        Node n3 = p.new Node(4);
        Node n4 = p.new Node(5);
        Node n5 = p.new Node(6);
        Node n6 = p.new Node(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        System.out.println(p.connect(root));
    }

}
