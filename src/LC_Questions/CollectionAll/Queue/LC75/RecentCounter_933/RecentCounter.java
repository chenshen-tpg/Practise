package LC_Questions.CollectionAll.Queue.LC75.RecentCounter_933;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> q;

    public static void main(String[] args) {

        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1)); // Expected output: 1
        // Test case 2
        System.out.println(counter.ping(100)); // Expected output: 2
        // Test case 3
        System.out.println(counter.ping(3001)); // Expected output: 3
        // Test case 4
        System.out.println(counter.ping(3002)); // Expected output: 3
    }
    public RecentCounter() {
        q = new LinkedList<>();
    }
    //seems not right but accepted...
    public int ping(int t) {
        int ans = 1;
        q.add(t);
        int lowerBound = t - 3000;
        int highBound = t;
        for (Integer i:q) {
            if (lowerBound <= i && i < highBound) {
                ans++;
            }
        }
        return ans;
    }
}
