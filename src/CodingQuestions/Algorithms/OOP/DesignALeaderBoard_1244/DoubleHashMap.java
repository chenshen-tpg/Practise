package CodingQuestions.Algorithms.OOP.DesignALeaderBoard_1244;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DoubleHashMap {
    private Map<Integer, Integer> playerMap;
    private Map<Integer, Set<Integer>> scoreMap;
    public DoubleHashMap() {
        this.playerMap = new HashMap<>();
        this.scoreMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        if (!playerMap.containsKey(playerId)) {
            playerMap.put(playerId, score);
            scoreMap.putIfAbsent(score, new HashSet<>());
            scoreMap.get(score).add(playerId);
            return;
        }

        int existing = playerMap.get(playerId);
        scoreMap.get(existing).remove(playerId);
        playerMap.put(playerId, existing + score);
        scoreMap.putIfAbsent(existing + score, new HashSet<>());
        scoreMap.get(existing + score).add(playerId);
    }

    public int top(int K) {
        int total = 0;
        for (Map.Entry<Integer,Set<Integer>> entry: scoreMap.entrySet()) {
            int score = entry.getKey();
            Set<Integer> players = entry.getValue();
            if (players.size() <= K) {
                total += (score * players.size());
                K -= players.size();
                continue;
            }
            if (K == 0) {
                break;
            }
            total += (score * K);
            K = 0;
        }

        return total;
    }

    public void reset(int playerId) {
        int existing = playerMap.get(playerId);
        scoreMap.get(existing).remove(playerId);
        playerMap.remove(playerId);
    }
}
