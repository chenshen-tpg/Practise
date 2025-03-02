package LC_Questions.Tree.LC150.PopulatingNextRightPointersInEachNode_117;

import Lib.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

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
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        System.out.println(p.connect(root));
    }

}
