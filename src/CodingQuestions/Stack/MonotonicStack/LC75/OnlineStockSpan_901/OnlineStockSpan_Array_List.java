package CodingQuestions.Stack.MonotonicStack.LC75.OnlineStockSpan_901;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan_Array_List {
    List<Integer> li;
    int [] span;
    public static void main(String[] args) {
        OnlineStockSpan_Array_List o = new OnlineStockSpan_Array_List();
        System.out.println(o.next(100));
        System.out.println(o.next(80));
        System.out.println(o.next(60));
        System.out.println(o.next(75));
        System.out.println(o.next(60));
        System.out.println(o.next(75));
        System.out.println(o.next(85));
//        null, 1, 1, 1, 2, 1, 4, 6
        // maximum number of consecutive days
    }
    public OnlineStockSpan_Array_List() {
        li = new ArrayList<>();
        span = new int[10000];
    }
    public int next(int price) {
        int ans = 0;
        int index = 0;
        if (li.size() == 0) {
            span[index] = 1;
            li.add(price);
            index++;
        }
        while (index <= li.size()) {
            span[index] = span[index - 1] + li.get(index - 1);
            if (index > ans) {
                ans = index;
            } else {
                span[index] = 1;
                index++;
            }
        }
        return ans;
    }
}
