package CodingQuestions.Algorithms.OOP.DesignTaskManager_3408;

import java.util.*;

public class SampleAnswer {
    private PriorityQueue<int[]> pq;
    private Map<Integer, Integer> taskPriority;
    private Map<Integer, Integer> taskOwner;

    public static void main(String[] args) {
        SampleAnswer tm = new SampleAnswer(
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

    public SampleAnswer(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        taskPriority = new HashMap<>();
        taskOwner = new HashMap<>();
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        pq.add(new int[]{priority, taskId});
        taskPriority.put(taskId, priority);
        taskOwner.put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        pq.add(new int[]{newPriority, taskId});
        taskPriority.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        taskPriority.put(taskId, -1);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int p = t[0], id = t[1];
            if (taskPriority.getOrDefault(id, -2) == p) {
                taskPriority.put(id, -1);
                return taskOwner.getOrDefault(id, -1);
            }
        }
        return -1;
    }
}
