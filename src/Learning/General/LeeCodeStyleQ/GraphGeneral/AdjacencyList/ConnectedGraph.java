package Learning.General.LeeCodeStyleQ.GraphGeneral.AdjacencyList;

import java.util.ArrayList;
import java.util.List;

public class ConnectedGraph {
    public static void main(String[] args) {
        ConnectedGraph solution = new ConnectedGraph();
        solution.buildGraph(new int[][] {{0,1}, {1,2},{2,3},{3,0},{0,2} });
    }

    public  void buildGraph (int [][] arr) {
        List<List<Integer>> temp = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            temp.add(new ArrayList<>());
        }
        for (int [] a : arr) {
            temp.get(a[0]).add(a[1]);
        }

        for (int i = 0; i < temp.size(); i++) {
            int count = 1;
            for (int j = 0; j < temp.get(i).size(); j++) {
                if (count -- == 1) System.out.print("node " + i + " includes: " );
                System.out.print(temp.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
