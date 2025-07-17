package CodingQuestions.Array.ArrayGeneral.PremiumAlgo100.ReverseWordsInAStringII;

public class Review {
    public static void main(String[] args) {
        Review solution = new Review();
        solution.reverseWords(new char [] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
        System.out.println("");
    }
    public void reverseWords(char[] s) {
        reverse(s,0, s.length - 1);
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == s.length || s[i] == ' ') {
                reverse(s,j, i - 1);
                j = i + 1;
            }
        }
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp  = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
