package CodingQuestions.Algorithms.OOP.DesignALeaderBoard_1244;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapModelSolution {
    // Key can only hold one, so value can only identify how many.
    Map<Integer, Integer> scores;
    TreeMap<Integer, Integer> sortedScores;

    public TreeMapModelSolution() {
        this.scores = new HashMap<Integer, Integer>();
        this.sortedScores = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        if (!scores.containsKey(playerId)) {
            scores.put(playerId, score);
            sortedScores.put(score, sortedScores.getOrDefault(score, 0) + 1);
        } else {
            int preScore = scores.get(playerId);
            int playerCount = sortedScores.get(preScore);
            if (playerCount == 1) {
                sortedScores.remove(preScore);
            } else {
                sortedScores.put(preScore, playerCount - 1);
            }
            int newScore = preScore + score;
            scores.put(playerId, newScore);
            sortedScores.put(newScore, sortedScores.getOrDefault(newScore, 0) + 1);
        }
    }

    public int top(int K) {
        int count = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: this.sortedScores.entrySet()) {
            int times = entry.getValue();
            int key = entry.getKey();
            for (int i = 0; i < times; i++) {
                sum += key;
                count++;
                if (count == K) {
                    break;
                }
            }
            if (count == K) {
                break;
            }
        }

        return sum;
    }

    public void reset(int playerId) {
        int preScore = this.scores.get(playerId);
        this.sortedScores.put(preScore, this.sortedScores.get(preScore) - 1);
        if (this.sortedScores.get(preScore) == 0) {
            this.sortedScores.remove(preScore);
        }

        this.scores.remove(playerId);
    }

    public static void main(String[] args) {
        TreeMapModelSolution leaderboard = new TreeMapModelSolution();
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
