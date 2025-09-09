package CodingQuestions.Algorithms.Array.ArrayGeneral.RepeatSubString_459;

public class ModelAns1 {
    public static void main(String[] args) {

    }
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        if (t.substring(1, t.length() - 1).contains(s))
            return true;
        return false;
    }
}
