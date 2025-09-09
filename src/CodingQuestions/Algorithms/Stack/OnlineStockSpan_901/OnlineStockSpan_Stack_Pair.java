package CodingQuestions.Algorithms.Stack.OnlineStockSpan_901;

import CodingQuestions.Lib.Pair;

import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan_Stack_Pair {

    Stack<Pair> stack2 = new Stack<>();
    ArrayList<Integer> al = new ArrayList<>();
    public static void main(String[] args) {
        OnlineStockSpan_Stack_Pair o = new OnlineStockSpan_Stack_Pair();
        System.out.println(o.next(100));
        System.out.println(o.next(80));
        System.out.println(o.next(60));
        System.out.println(o.next(70));
        System.out.println(o.next(60));
        System.out.println(o.next(75));
        System.out.println(o.next(85));
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
        while (!stack2.isEmpty() && ((int) stack2.peek().getKey() <= price)) {
            ans += (int) stack2.pop().getValue();
        }
        stack2.push(new Pair(price, ans));
        return ans;
    }
}
