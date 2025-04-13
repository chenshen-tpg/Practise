package LC_Questions.Graph.Graph.Others.CourseScheduleIV_1462;

import java.util.ArrayList;
import java.util.List;

public class Floyd_Warshallalgorithm {
    public static void main(String[] args) {
        Floyd_Warshallalgorithm solution = new Floyd_Warshallalgorithm();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[][] queries = {{0, 1}, {1, 0}};
        List<Boolean> result = solution.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(result);
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable = new boolean[numCourses][numCourses];
        for (int[] prereq : prerequisites) {
            int u = prereq[0], v = prereq[1];
            reachable[u][v] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int u = 0; u < numCourses; u++) {
                for (int v = 0; v < numCourses; v++) {
                    reachable[u][v] = reachable[u][v] || (reachable[u][k] && reachable[k][v]);
                }
            }
        }
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0], v = query[1];
            answer.add(reachable[u][v]);
        }
        return answer;
    }
}
