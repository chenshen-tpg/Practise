package LC_Questions.CollectionAll.BackTracking.LC150.GenerateParenthese_22;

import java.util.ArrayList;
import java.util.List;

public class review {
    public  List<String> al = new ArrayList<>();

    public static void main(String[] args) {
        review solution = new review();
        System.out.println(solution.generateParenthesis());
    }

    private  List<String> generateParenthesis() {
         helper(0,0,3,"");
         return al;
    }

    public  void helper (int l, int r, int len, String res) {
        if (l == len && r == len) {
            al.add(res);
            return;
        }
        if (l < len) helper(l+1, r,len,res + "(");
        if (l > r) helper(l, r + 1, len, res + ")");
    }
}
