package CodingQuestions.Graph.Graph.Others.CourseScheduleIV_1462;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_UVList {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            int u = prereq[0], v = prereq[1];
            graph.get(u).add(v);
        }

        boolean[][] reachable = new boolean[numCourses][numCourses];
        for (int u = 0; u < numCourses; u++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(u);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int neighbor : graph.get(current)) {
                    if (!reachable[u][neighbor]) {
                        reachable[u][neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Answer the queries
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0], v = query[1];
            answer.add(reachable[u][v]);
        }

        return answer;
    }

    // Example usage
    public static void main(String[] args) {
        BFS_UVList solution = new BFS_UVList();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[][] queries = {{0, 1}, {1, 0}};
        List<Boolean> result = solution.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(result); // Output: [false, true]
    }
}
