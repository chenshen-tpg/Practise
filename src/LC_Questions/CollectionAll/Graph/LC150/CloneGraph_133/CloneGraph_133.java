package LC_Questions.CollectionAll.Graph.LC150.CloneGraph_133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        CloneGraph_133 cg = new CloneGraph_133();
        Node node = cg.new Node(1);
        node.neighbors.add(cg.new Node(2));
        node.neighbors.add(cg.new Node(4));
        node.neighbors.get(0).neighbors.add(cg.new Node(3));
        node.neighbors.get(1).neighbors.add(cg.new Node(3));
        Node clone = cg.cloneGraph(node);
        System.out.println(clone.val);
    }
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList());
        visited.put(node, cloneNode);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
