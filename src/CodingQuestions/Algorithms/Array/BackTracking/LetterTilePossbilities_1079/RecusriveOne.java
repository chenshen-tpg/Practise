package CodingQuestions.Algorithms.Array.BackTracking.LetterTilePossbilities_1079;

import java.util.HashSet;
import java.util.Set;

public class RecusriveOne {

    public static void main(String[] args) {
        RecusriveOne solution = new RecusriveOne();
        solution.numTilePossibilities("AAB");
    }

    public int numTilePossibilities(String tiles) {
        Set<String> sequences = new HashSet<>();
        int len = tiles.length();
        boolean[] used = new boolean[len];
        generateSequences(tiles, "", used, sequences);
        return sequences.size() - 1;
    }

    public void generateSequences(String tiles, String current, boolean[] used, Set<String> sequences) {
        sequences.add(current);
        for (int i = 0; i < tiles.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                // next available element needs to be considered
                generateSequences(tiles, current + tiles.charAt(i), used, sequences);
                used[i] = false;
            }
        }
    }
}
