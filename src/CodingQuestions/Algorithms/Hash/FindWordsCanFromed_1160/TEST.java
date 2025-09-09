package CodingQuestions.Algorithms.Hash.FindWordsCanFromed_1160;

public class TEST {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int [] memo = new int [26];
        for (int i = 0; i < chars.length(); i++) memo[chars.charAt(i) - 'a']++;
        for (String word :  words) {
            int [] temp = new int [26];
            for (int i = 0; i < word.length();i++) {
                temp[word.charAt(i) - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (temp[i] > memo[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans+= word.length();
            }
        }
        return ans;
    }
}
