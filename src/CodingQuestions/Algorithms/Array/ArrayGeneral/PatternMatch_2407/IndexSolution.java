package CodingQuestions.Algorithms.Array.ArrayGeneral.PatternMatch_2407;

public class IndexSolution {
    public static void main(String[] args) {
        String s = "leetcode", p = "ee*e";

//        System.out.println(hasMatch(s,p));
        System.out.println(s.substring(p.indexOf('*')));
    }

    public static boolean hasMatch(String s, String p) {
        int split = s.indexOf('*');
        int firstPosition = s.indexOf(p.substring(0, split));
        int secondPosition = s.indexOf(p.substring(split + 1), split + firstPosition);
        return firstPosition != -1 && secondPosition != -1 ? true : false;
    }

}
