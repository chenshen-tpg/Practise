package LC_Questions.CollectionAll.Heap.Others;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class RootEqualsSumOfChildren_2336 {


    static Set<Integer> add = new HashSet<>();
    static PriorityQueue<Integer> pr = new PriorityQueue();

    static Integer cur = 1;

    public static void add (int num) {

        if (num <= cur || add.contains(num)) {
            return;
        }
        add.add(num);
        pr.add(num);
    }
    public static void popSmallet(){
        int ans;
        if (!pr.isEmpty()) {
            ans = pr.poll();
            pr.remove(ans);
        }
        ans = cur;
        cur += 1;
    }

    public static void main(String[] args) {

    }
}
