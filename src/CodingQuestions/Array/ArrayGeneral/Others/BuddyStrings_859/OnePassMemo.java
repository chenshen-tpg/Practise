package CodingQuestions.Array.ArrayGeneral.Others.BuddyStrings_859;

public class OnePassMemo {
    public static void main(String[] args) {

    }
    public boolean linear(String s, String goal) {
        int count = 0;
        int [] memo = new int [26];
        if (s.length() != goal.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                memo[s.charAt(i) - 'a']++;
                memo[goal.charAt(i) - 'a']++;
            }
        }
        if (count > 2) return false;
        for (int i = 0; i < 26; i++) {
            if (memo[i] > 0 && memo[i] != 2) {
                return false;
            }
        }
        return true;
    }
}
