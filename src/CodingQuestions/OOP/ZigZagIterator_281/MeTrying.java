package CodingQuestions.OOP.ZigZagIterator_281;

import java.util.ArrayList;
import java.util.List;

public class MeTrying {
    public static void main(String[] args) {

    }
    public class ZigzagIterator {
        List<Integer> li;
        int start;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            li = new ArrayList();
            start = 0;
            int index1 = 0, end1 = v1.size();
            int index2 = 0, end2 = v2.size();
            while (index1 < end1 && index2 < end2) {
                li.add(v1.get(index1++));
                li.add(v2.get(index2++));
            }
            while (index1 < end1) {
                li.add(v1.get(index1++));
            }
            while (index2 < end2) {
                li.add(v2.get(index2++));
            }
        }

        public int next() {
            return li.get(start++);
        }

        public boolean hasNext() {
            if (start < li.size()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
