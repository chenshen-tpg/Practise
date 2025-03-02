package LC_Questions.Queue.LC75.RecentCounter_933;

import java.util.LinkedList;

public class ModelAnswer {
    LinkedList<Integer> slideWindow;

    public ModelAnswer() {
        this.slideWindow = new LinkedList<Integer>();
    }

    public int ping(int t) {
        this.slideWindow.addLast(t);
        while (this.slideWindow.getFirst() < t - 3000)
            this.slideWindow.removeFirst();
        return this.slideWindow.size();
    }
}
