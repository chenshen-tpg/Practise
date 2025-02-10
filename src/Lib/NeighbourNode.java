package Lib;

import java.util.ArrayList;
import java.util.List;

public class NeighbourNode {
    public int val;
    public List<NeighbourNode> neighbors;

    public NeighbourNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public NeighbourNode(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public NeighbourNode(int _val, ArrayList<NeighbourNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
