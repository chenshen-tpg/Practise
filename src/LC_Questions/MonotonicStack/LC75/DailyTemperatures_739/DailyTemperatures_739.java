package LC_Questions.MonotonicStack.LC75.DailyTemperatures_739;

import java.util.Stack;

public class DailyTemperatures_739 {
    public static void main(String[] args) {
        DailyTemperatures_739 d = new DailyTemperatures_739();
        int[] res = d.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i : res) {
            System.out.println(i);
        }
    }
    private int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int curTem = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] < curTem) {
                int prevDay = stack.pop();
                ans[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

    return ans;
}
    public int[] dailyTemperatures_model(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack <Integer> stack = new Stack<>();

        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temperatures[currDay];
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }

        return answer;
    }
    private int[] dailyTemperatures_bruteForce(int[] arr) {
        int [] ans = new int [arr.length];
        int index = 0;
        for (int i = 0; i < arr.length;i++) {
            int count = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] <= arr[i]) {
                    count++;
                } else {
                    ans[index++] = count;
                    break;
                }
            }
        }
        return ans;
    }


    private int[] dailyTemperatures_gpt(int[] arr) {
        Stack <int[]> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()[0]) {
                int[] temp = stack.pop();
                arr[temp[1]] = i - temp[1];
            }
            stack.push(new int[]{arr[i], i});
            arr[i] = 0;
        }
        return arr;
    }

}
