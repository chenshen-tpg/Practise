package LC_Questions.WholePackage.MonotonicStack.LC75.OnlineStockSpan_901;

import java.util.Stack;

public class Submitted_Answer {
    Stack<int[]> stack = new Stack<>();

    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }
        stack.push(new int[] {price, ans});
        return ans;
    }
}
