package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.ValidAnagram_242;

public class MyNewInitialWriting {
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int [] memo1 = new int [26];
        int [] memo2 = new int [26];
        for (int i = 0; i < s.length(); i++) {
            memo1[s.charAt(i) - 'a']++;
            memo2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (memo1[i] != memo2[i]) return false;
        }
        return true;
    }
}
