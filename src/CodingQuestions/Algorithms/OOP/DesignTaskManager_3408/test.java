package CodingQuestions.Algorithms.OOP.DesignTaskManager_3408;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class test {
    PriorityQueue<int []> pq;
    HashMap<Integer, Integer> IDMap;
    HashMap<Integer, Integer> hmPriority;
    public static void main(String[] args) {
        test tm = new test(
                Arrays.asList(
                        Arrays.asList(1, 101, 10),
                        Arrays.asList(2, 102, 20),
                        Arrays.asList(3, 103, 15)
                )
        );
        tm.add(4, 104, 5);
        tm.edit(102, 8);
        System.out.println(tm.execTop());
        tm.rmv(101);
        tm.add(5, 105, 15);
        System.out.println(tm.execTop());
    }
    public test(List<List<Integer>> tasks) {
       pq = new PriorityQueue<>((a,b) -> {
           if (b[0] != a[0]) return b[0] - a[0];
           return b[1] - a[1];
       });
        hmPriority = new HashMap<>();
        IDMap = new HashMap<>();
        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        IDMap.put(taskId, userId);
        hmPriority.put(taskId,priority);
        pq.add((new int [] {priority, taskId}));
    }

    public void edit(int taskId, int newPriority) {
        pq.add(new int [] {newPriority, taskId});
        hmPriority.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        hmPriority.put(taskId, -1);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int p = t[0], id = t[1];
            if (hmPriority.getOrDefault(id, -3) == p) {
                hmPriority.put(id, -1);
                return IDMap.getOrDefault(id, - 1);
            }
        }
        return -1;
    }
}
