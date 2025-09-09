package CodingQuestions.Algorithms.Array.BackTracking.GenerateParenthese_22;

import java.util.ArrayList;
import java.util.List;

public class Recusrive {
    public List<String> al = new ArrayList<>();

    public static void main(String[] args) {
        Recusrive solution = new Recusrive();
        System.out.println(solution.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        recursive(0,0,n, "");
        return al;
    }
    private void recursive(int left,int right, int max, String s) {
        if (left == max & right == max) {
            al.add(s);
            return;
        }
        if (left < max) {
            recursive(left + 1, right, max, s + "(");
        }
        if (left > right) {
            recursive(left, right + 1, max, s + ")");
        }
    }
}
