package LC_Questions.LC_75.MonotonicStack;

import java.util.Stack;

public class OnlineStockSpan_901 {
    Stack<int[]> stack = new Stack<>();
    public static void main(String[] args) {
        OnlineStockSpan_901 o = new OnlineStockSpan_901();
        System.out.println(o.next(100));
        System.out.println(o.next(80));
        System.out.println(o.next(60));
        System.out.println(o.next(70));
        System.out.println(o.next(60));
        System.out.println(o.next(75));
        System.out.println(o.next(85));
    }

    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }
        stack.push(new int[] {price, ans});
        return ans;
    }

}
