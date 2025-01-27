package LC_Questions.CollectionAll.Graph.LC75.KeysAndRooms_841;

import java.util.List;
import java.util.Stack;

public class StackBFS {
    public static void main(String[] args) {

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);
        while(!stack.empty()) {
            int node = stack.pop();
            for (int c:rooms.get(node)) {
                if (!seen[c]) {
                    seen[c] = true;
                    stack.push(c);
                }
            }
        }
        for (boolean v: seen)
            if (!v) return false;
        return true;
    }
}
