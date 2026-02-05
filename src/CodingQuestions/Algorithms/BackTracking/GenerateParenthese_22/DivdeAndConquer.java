package CodingQuestions.Algorithms.BackTracking.GenerateParenthese_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivdeAndConquer {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList(Arrays.asList(""));
        List<String> answer = new ArrayList();
        for (int leftCount = 0; leftCount < n; leftCount ++ )
            for (String leftString : generateParenthesis(leftCount))
                for (String rightString : generateParenthesis(n - 1 - leftCount))
                    answer.add("(" + leftString + ")" + rightString);
        return answer;
    }
}
