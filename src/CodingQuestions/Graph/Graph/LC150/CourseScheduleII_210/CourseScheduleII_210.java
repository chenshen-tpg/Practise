package CodingQuestions.Graph.Graph.LC150.CourseScheduleII_210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII_210 {
    public static void main(String[] args) {
        CourseScheduleII_210 c = new CourseScheduleII_210();
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] res = c.findOrder(4, prerequisites);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> temp = adjList.getOrDefault(prerequisites[i][1], new ArrayList<>());
            temp.add(prerequisites[i][0]);
            adjList.put(prerequisites[i][1], temp);
            indegree[prerequisites[i][0]] += 1;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) q.add(i);
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            res[i++] = node;
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }
        return i == numCourses ? res : new int[0];
    }
}
