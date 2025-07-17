package CodingQuestions.Graph.Graph.LC150.CloneGraph_133;

import CodingQuestions.Lib.NeighbourNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) {
        BFS cg = new BFS();
        NeighbourNode node = new NeighbourNode(1);
        node.neighbors.add(new NeighbourNode(2));
        node.neighbors.add(new NeighbourNode(4));
        node.neighbors.get(0).neighbors.add(new NeighbourNode(3));
        node.neighbors.get(1).neighbors.add(new NeighbourNode(3));
        NeighbourNode clone = cg.cloneGraph(node);
        System.out.println(clone.val);
    }

    private NeighbourNode cloneGraph(NeighbourNode node) {
        if (node == null) return node;
        HashMap<NeighbourNode, NeighbourNode> visited = new HashMap();
        LinkedList<NeighbourNode> q = new LinkedList<>();
        q.add(node);
        visited.put(node, new NeighbourNode(node.val, new ArrayList()));
        while (!q.isEmpty()) {
            NeighbourNode n = q.remove();
            for (NeighbourNode neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new NeighbourNode(neighbor.val, new ArrayList()));
                    q.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

}
