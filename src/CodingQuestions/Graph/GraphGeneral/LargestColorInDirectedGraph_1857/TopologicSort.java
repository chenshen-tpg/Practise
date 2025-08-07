package CodingQuestions.Graph.GraphGeneral.LargestColorInDirectedGraph_1857;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicSort {
    public static void main(String[] args) {
        // Define courses
        Map<String, Integer> courseToIndex = new HashMap<>();
        courseToIndex.put("A", 0);
        courseToIndex.put("B", 1);
        courseToIndex.put("C", 2);
        courseToIndex.put("D", 3);
        courseToIndex.put("E", 4);
        String[] indexToCourse = new String[5];
        indexToCourse[0] = "A";
        indexToCourse[1] = "B";
        indexToCourse[2] = "C";
        indexToCourse[3] = "D";
        indexToCourse[4] = "E";
        int numCourses = courseToIndex.size();
        // Define prerequisites (edges: [prerequisite, dependent_course])
        // Example: A -> C is {0, 2} because A is index 0, C is index 2
        int[][] prerequisites = {
                {courseToIndex.get("A"), courseToIndex.get("C")}, // A -> C
                {courseToIndex.get("A"), courseToIndex.get("D")}, // A -> D
                {courseToIndex.get("B"), courseToIndex.get("D")}, // B -> D
                {courseToIndex.get("C"), courseToIndex.get("E")}  // C -> E
        };
        List<String> schedule = topologicalSort(numCourses, courseToIndex, indexToCourse, prerequisites);
        if (!schedule.isEmpty()) {
            System.out.println("Valid course schedule:");
            System.out.println(schedule);
        }
    }

    public static List<String> topologicalSort(int numCourses, Map<String, Integer> courseToIndex, String[] indexToCourse, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        // Build the graph and calculate in-degrees from prerequisites
        for (int[] prereq : prerequisites) {
            int u = prereq[0]; // Prerequisite course index
            int v = prereq[1]; // Course that depends on the prerequisite
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        List<String> sortedOrder = new ArrayList<>();
        int visitedNodes = 0;
        while (!q.isEmpty()) {
            int u = q.poll(); // Get a course with no pending prerequisites
            sortedOrder.add(indexToCourse[u]); // Add it to the sorted list
            visitedNodes++;
            // For each course 'v' that depends on 'u'
            for (int v : graph.get(u)) {
                indegree[v]--; // Decrement in-degree of 'v'
                // If 'v' now has no pending prerequisites, add it to the queue
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        if (visitedNodes == numCourses) {
            return sortedOrder;
        } else {
            System.out.println("Cycle detected! Cannot schedule all courses.");
            return Collections.emptyList();
        }
    }


}
