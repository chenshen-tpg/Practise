package Learning.General.LeeCodeStyleQ.Stack.DailyTemp_739;

import java.util.Stack;

public class TEST {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Stack<int[]> stack = new Stack();
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[i] > stack.peek()[0]) {
                int[] cur = stack.pop();
                int pos = cur[1];
                res[pos] = i - pos;
            }
            stack.push(new int[] { temps[i], i });
        }
        return res;

    }
}
