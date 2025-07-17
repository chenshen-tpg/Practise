package CodingQuestions.Hash.PremiumAlgo100.SingleKeyboard_1165;

public class TEST {
    public static void main(String[] args) {

    }
    public int calculateTime(String keyboard, String word) {
        int [] memo = new int [26];
        for (int i = 0; i < keyboard.length(); i++) {
            memo[keyboard.charAt(i) - 'a'] = i;
        }
        int count = 0;
        int cur = 0;
        for (int i = 0; i < word.length(); i++) {
            count += Math.abs(memo[word.charAt(i) - 'a'] - cur);
            cur = memo[word.charAt(i) - 'a'];
        }
        return count;
    }
}
