package LC_Questions.Graph.Graph.LC150.CloneGraph_133;

import Lib.NeighbourNode;

import java.util.ArrayList;
import java.util.HashMap;

public class DFS {


    public static void main(String[] args) {
        DFS cg = new DFS();
        NeighbourNode node = new NeighbourNode(1);
        node.neighbors.add(new NeighbourNode(2));
        node.neighbors.add(new NeighbourNode(4));
        node.neighbors.get(0).neighbors.add(new NeighbourNode(3));
        node.neighbors.get(1).neighbors.add(new NeighbourNode(3));
        NeighbourNode clone = cg.cloneGraph(node);
        System.out.println(clone.val);
    }
    private HashMap<NeighbourNode, NeighbourNode> visited = new HashMap<>();
    public NeighbourNode cloneGraph(NeighbourNode node) {
        if (node == null) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        NeighbourNode cloneNode = new NeighbourNode(node.val, new ArrayList());
        visited.put(node, cloneNode);
        for (NeighbourNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
