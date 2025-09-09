package CodingQuestions.Algorithms.Array.ArrayGeneral.RepeatSubString_459;

public class MeTringInitial {
    public boolean repeatedSubstringPattern(String s) {
        int count = 0;
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!temp.toString().contains(s.charAt(i)+"")) {
                temp.append(s.charAt(i));
            } else {
                if (s.contains(temp.toString())){
                    count++;
                }
            }
        }
        if (s.length() == 2 && count == 1) return true;
        return count > 1 ? true : false;
    }
}
