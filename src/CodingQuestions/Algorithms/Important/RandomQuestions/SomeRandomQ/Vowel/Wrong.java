package CodingQuestions.Algorithms.Important.RandomQuestions.SomeRandomQ.Vowel;

public class Wrong {
    /***
     * Given a string s and an integer k, find the maximum number of vowels
     * present in any substring of s that has a length k. Write a function to return the highest
     * count of vowel letters you can find in such a substring.
     * Implement the method maxVowels(String s, int k) to return max number of vowels.
     */
    public static void main(String[] args) {
        Wrong test = new Wrong();
        String s = "AEIOIIioufsdkfdsjk";
        test.maxVowels(s, s.length());
    }

    public int maxVowels(String s, int k) {
        int ans = 0;
        int[] store = new int[5];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.toLowerCase(cur) == 'a') {
                store[0]++;
            } else if (Character.toLowerCase(cur) == 'e') {
                store[1]++;
            } else if (Character.toLowerCase(cur) == 'i') {
                store[2]++;
            } else if (Character.toLowerCase(cur) == 'o') {
                store[3]++;
            } else if (Character.toLowerCase(cur) == 'u') {
                store[4]++;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (store[i] > ans) {
                ans = store[i];
            }
        }
        return ans;
    }
}
