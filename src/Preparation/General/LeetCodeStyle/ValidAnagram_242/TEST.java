package Preparation.General.LeetCodeStyle.ValidAnagram_242;

public class TEST {
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        int [] memo = new int [26];
        for (int i = 0; i < s.length();i++) {
            char temp = s.charAt(i);
            memo[temp - 'a']++;
        }
        for (int i = 0; i < t.length();i++) {
            char temp = t.charAt(i);
            memo[temp - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (memo[i] != 0) return false;
        }
        return true;
    }
}
