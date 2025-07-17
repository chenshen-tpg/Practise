package CodingQuestions.Graph.Matrix.PremiumAlgo100.ValidWordSqaure_422;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> li = new ArrayList<>();
        li.add("abcd");
        li.add("bnrt");
        li.add("crmy");
        li.add("dtye");
    }

    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                //check the i,j since they are swapped
                if (j >= words.size() || j >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
