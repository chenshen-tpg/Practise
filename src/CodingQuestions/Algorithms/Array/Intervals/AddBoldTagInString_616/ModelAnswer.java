package CodingQuestions.Algorithms.Array.Intervals.AddBoldTagInString_616;

public class ModelAnswer {
    public static void main(String[] args) {
        ModelAnswer solution = new ModelAnswer();
        solution.addBoldTag("abcxyz123", new String[]{"abc", "123"});
    }

    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        for (String word : words) {
            int start = s.indexOf(word);
            while (start != -1) {
                for (int i = start; i < start + word.length(); i++) {
                    bold[i] = true;
                }
                start = s.indexOf(word, start + 1);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (bold[i] && (i == 0 || !bold[i - 1])) ans.append("<b>");
            ans.append(s.charAt(i));
            if (bold[i] && (i == s.length() - 1 || !bold[i + 1])) ans.append("</b>");
        }
        return ans.toString();
    }
}
