package LC_Questions.WholePackage.MonotonicStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OnlineStockSpan_901 {
    class Pair {
        int price;
        int index;

        Pair(Integer price , Integer index){
            this.price = price;
            this.index = index;
        }
    }

    Stack<int[]> stack = new Stack<>();
    Stack<Pair> stack2 = new Stack<>();
    ArrayList<Integer> al = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
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

    public int next_stack(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }
        stack.push(new int[] {price, ans});
        return ans;
    }
    public int next_array(int price) {
        int ans = 1;
        al.add(price);
        for (int i = al.size() - 2; i >= 0; i--) {
            if (al.get(i) <= price) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
    public int next(int price) {
        int ans = 1;
        while (!stack2.isEmpty() && stack2.peek().price <= price) {
            ans += stack2.pop().index;
        }
        stack2.push(new Pair(price, ans));
        return ans;
    }
}
