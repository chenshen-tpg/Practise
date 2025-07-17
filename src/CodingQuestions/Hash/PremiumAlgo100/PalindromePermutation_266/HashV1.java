package CodingQuestions.Hash.PremiumAlgo100.PalindromePermutation_266;

public class HashV1 {
    public static void main(String[] args) {

    }
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 1) return true;
        int count = 0;
        int [] memo = new int [26];
        for (int i = 0; i < s.length(); i++) {
            memo[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < memo.length;i++) {
            count += memo[i] % 2;
        }
        return count <= 1;
    }
}
