package CodingQuestions.Algorithms.SomeContest.WeeklyContest_2;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        System.out.println(solution.findTheDifference("abcde", "abcdef"));
    }
    public char findTheDifference(String s, String t) {
        int [] memo = new int [26];

        for (int i = 0; i < t.length(); i++) {
            memo[t.charAt(i) -'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            memo[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 128; i++) {
            if (memo[i] == 1) return (char)('a' + i);
        }
        return ' ';
    }
}
