package CodingQuestions.Hash.FindMirrorScoreOfAString_3412;


public class PrefixSolution {

    public static void main(String[] args) {
        System.out.println(calculateScore("aczzx"));
    }


    public static long calculateScore(String s) {
        long score = 0;
        int[] markForward = new int[26];
        int[] markBackWard = new int[26];
        for (int i = 0; i < s.length(); i++) {
            markForward[s.charAt(i) - 'a'] += 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            markBackWard[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (markForward[i] == 1 && markBackWard[j] == 1) {
                    markForward[i] = 0;
                    markBackWard[j] = 0;
                    score += i - j;
                }
            }
        }
        return score;
    }

}
