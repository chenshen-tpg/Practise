package CodingQuestions.Graph.GraphGeneral.KeysAndRooms_841;

import java.util.List;

public class SampleAns1 {
    public static void main(String[] args) {

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for(boolean roomVisited : visited) {
            if(!roomVisited) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;

        for(int key : rooms.get(room)) {
            if(!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
