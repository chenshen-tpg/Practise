package CodingQuestions.Queue.LC75.Dota2Senate_649;

import java.util.LinkedList;

public class Dota2Senate_649 {
    public static void main(String[] args) {

    }


    public String helper(String senate) {
        LinkedList<Integer> r = new LinkedList<>(), d = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'D')  d.add(i);
            else r.add(i);
        }
        while(!r.isEmpty() && !d.isEmpty()) {
            if (r.peek() > d.peek()) d.add(n++);
            else r.add(n++);
            r.pop();
            d.pop();
        }
        return (r.isEmpty()) ? "Dire" : "Radiant";
    }
}
