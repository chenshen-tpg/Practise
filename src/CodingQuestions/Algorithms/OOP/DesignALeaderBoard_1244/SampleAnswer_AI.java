package CodingQuestions.Algorithms.OOP.DesignALeaderBoard_1244;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SampleAnswer_AI {
    private Map<Integer, Integer> scores;

    public SampleAnswer_AI() {
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int score : scores.values()) {
            pq.add(score);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }

    public void reset(int playerId) {
        scores.remove(playerId);
    }

    public static void main(String[] args) {

    }
}
