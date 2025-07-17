package CodingQuestions.Graph.Graph.LC150.CloneGraph_133;

import CodingQuestions.Lib.NeighbourNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Reivew {
    public static void main(String[] args) {

    }
    public NeighbourNode clone (NeighbourNode node) {
        if (node == null) return node;
        HashMap<NeighbourNode, NeighbourNode> hm = new HashMap<>();
        Queue<NeighbourNode> q = new LinkedList<>();
        q.offer(node);
        hm.put(node, new NeighbourNode(node.val, new ArrayList<>()));
        while (!q.isEmpty()) {
            NeighbourNode temp = q.poll();
            for (NeighbourNode nei : temp.neighbors) {
                if (!hm.containsKey(nei)) {
                    hm.put(nei, new NeighbourNode(nei.val, new ArrayList<>()));
                    q.offer(nei);
                }
                hm.get(temp).neighbors.add(hm.get(nei));
            }
        }
        return hm.get(node);
    }
}
