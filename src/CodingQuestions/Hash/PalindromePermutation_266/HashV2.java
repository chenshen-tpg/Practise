package CodingQuestions.Hash.PalindromePermutation_266;

public class HashV2 {
    public static void main(String[] args) {

    }
    public boolean canPermutePalindrome(String s) {
        int count = 0;
        int [] memo = new int [128];
        for (int i = 0; i < s.length(); i++) {
            memo[s.charAt(i)]++;
            if (memo[s.charAt(i)] % 2 != 0) count++;
        }
        return count <= 1;
    }
}
