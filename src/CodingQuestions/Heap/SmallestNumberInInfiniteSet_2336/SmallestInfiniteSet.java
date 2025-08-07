package CodingQuestions.Heap.SmallestNumberInInfiniteSet_2336;

import java.util.HashSet;
import java.util.PriorityQueue;

class SmallestInfiniteSet {
    public static void main(String[] args) {

    }

    private HashSet<Integer> add;
    private PriorityQueue<Integer> pr;
    private Integer cur;

    public SmallestInfiniteSet() {
        add = new HashSet<>();
        pr = new PriorityQueue<>();
        cur = 1;
    }

    public int popSmallest() {
        int ans;
        if (!add.isEmpty()) {
            ans = pr.poll();
            add.remove(ans);
        } else {
            ans = cur;
            cur += 1;
        }
        return ans;
    }

    public void addBack(int num) {
        if (cur <= num || add.contains(num)) {
            return;
        }
        add.add(num);
        pr.add(num);
    }
}

