package CodingQuestions.Graph.Matrix.LC150.GameOfLife_289;

import CodingQuestions.Lib.Pair;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Pair<Integer, Integer>> li = new ArrayList<>();
        int[][] board3 = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        int [] cord = {-1,0,1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int r = 1 + cord[i];
                int c = 1 + cord[j];
                if (!(cord[r] == 0 && cord[c] == 0)) {
                    li.add(new Pair(r, c));
                }
            }
        }
        for (int i = 0; i < li.size(); i++) {
            System.out.print("("+ li.get(i).getKey() + "," +li.get(i).getValue() +")" + " " );
        }
    }
}
