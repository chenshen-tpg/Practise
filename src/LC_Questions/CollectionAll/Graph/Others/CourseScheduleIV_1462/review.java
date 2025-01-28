package LC_Questions.CollectionAll.Graph.Others.CourseScheduleIV_1462;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class review {
    public static void main(String[] args) {
        review solution = new review();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[][] queries = {{0, 1}, {1, 0}};
        List<Boolean> result = solution.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(result);
    }

    private List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> al = new ArrayList<>();
        boolean [][] memo = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            al.add(new ArrayList<>());
        }
        for (int [] pre : prerequisites) {
            al.get(pre[0]).add(pre[1]);
        }
        for (int u = 0; u < numCourses; u++) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(u);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nei : al.get(cur)) {
                    if (!memo[u][nei]) {
                        memo[u][nei] = true;
                        q.offer(cur);
                    }
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) ans.add(memo[query[0]][query[1]]);
        return ans;
    }
}
