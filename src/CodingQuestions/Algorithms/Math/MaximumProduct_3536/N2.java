package CodingQuestions.Algorithms.Math.MaximumProduct_3536;

import java.util.ArrayList;
import java.util.List;

public class N2 {
    public static void main(String[] args) {

    }
    public int maxProduct(int n) {
        int ans = 0, temp = 0;
        if (n < 10) return n;
        List<Integer> li = new ArrayList();
        while (n != 0) {
            temp = n % 10;
            li.add(temp);
            n /= 10;
        }
        int max = 0;
        for (int i = 0; i < li.size(); i++) {
            for (int j = i + 1; j <li.size();j++) {
                ans = Math.max(ans, li.get(i) * li.get(j));
            }
        }
        return ans;
    }
}
