package CodingQuestions.Stack.StackGeneral.LC75.OnlineStockSpan_901;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan_BruteForce {

    List<Integer> li;
    public static void main(String[] args) {
        OnlineStockSpan_BruteForce o = new OnlineStockSpan_BruteForce();
        System.out.println(o.next(29));
        System.out.println(o.next(91));
        System.out.println(o.next(62));
        System.out.println(o.next(76));
        System.out.println(o.next(51));

//        null, 1, 1, 1, 2, 1, 4, 6
        // maximum number of consecutive days
    }

    public OnlineStockSpan_BruteForce() {
        li = new ArrayList<>();
    }
    public int next(int price) {
        int curIndex = 1;
        for (int i = 0; i < li.size(); i++) {
            if (price >= li.get(i)) {
                curIndex++;
            } else {
                curIndex = 1;
            }
        }
        li.add(price);
        return curIndex;
    }

}
