package LC_Questions.CollectionAll.Graph.LC75.KeysAndRooms_841;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueBFS {
    HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        );
        helper(rooms);
    }

    public static boolean helper (List<List<Integer>> rooms) {
        int[] memo = new int[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        memo[0] = 1;

        while (!q.isEmpty()) {
            int room = q.poll();
            for (int key : rooms.get(room)) {
                if (memo[key] == 0) {
                    memo[key] = 1;
                    q.add(key);
                }
            }
        }

        for (int i : memo) {
            if (i == 0) return false;
        }
        return true;
    }
}
