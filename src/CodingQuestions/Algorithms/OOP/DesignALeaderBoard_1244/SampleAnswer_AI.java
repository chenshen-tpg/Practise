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
        for (Map.Entry<Integer, Integer> entry: scores.entrySet()) {
            pq.add(entry.getValue());
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
        SampleAnswer_AI leaderboard = new SampleAnswer_AI();
        leaderboard.addScore(1, 73);
        leaderboard.addScore(2, 56);
        leaderboard.addScore(3, 39);
        leaderboard.addScore(4, 51);
        leaderboard.addScore(5, 4);
        System.out.println(leaderboard.top(1));
        leaderboard.reset(1);
        leaderboard.reset(2);
        leaderboard.addScore(2, 51);
        System.out.println(leaderboard.top(3));
    }
}
