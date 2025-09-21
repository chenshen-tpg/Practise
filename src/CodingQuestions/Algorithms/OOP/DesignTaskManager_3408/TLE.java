package CodingQuestions.Algorithms.OOP.DesignTaskManager_3408;

import java.util.ArrayList;
import java.util.List;

public class TLE {
    public static void main(String[] args) {

    }
    List<List<Integer>> li;
    public TLE(List<List<Integer>> tasks) {
        li = tasks;
    }

    public void add(int userId, int taskId, int priority) {
        List<Integer> temp = new ArrayList();
        temp.add(userId);
        temp.add(taskId);
        temp.add(priority);
        li.add(temp);
    }

    public void edit(int taskId, int newPriority) {
        for (int i = 0; i < li.size();i++) {
            if (li.get(i).get(1) == taskId) {
                li.get(i).set(2, newPriority);
            }
        }
    }

    public void rmv(int taskId) {
        for (int i = 0; i < li.size();i++) {
            if (li.get(i).get(1) == taskId) {
                li.remove(li.get(i));
            }
        }
    }

    public int execTop() {
        int max = 0;
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).get(2) > max) {
                max = li.get(i).get(2);
            }
        }
        int resId = 0;
        int taskId = -1;
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).get(2) == max && li.get(i).get(1) > taskId) {
                taskId = li.get(i).get(1);
                resId = i;
            }
        }
        if (li.size() == 0) return -1;
        int ans = li.get(resId).get(0);
        li.remove(resId);
        return ans;
    }
}
