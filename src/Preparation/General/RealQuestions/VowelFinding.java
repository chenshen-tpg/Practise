package Preparation.General.RealQuestions;

public class VowelFinding {
    public static void main(String[] args) {
        VowelFinding vf = new VowelFinding();
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println("Input: " + s1 + ", k = " + k1);
        System.out.println("Output: " + vf.maxVowels(s1, k1)); // Expected: 3

        // Test 2: All vowels
        String s2 = "aeiou";
        int k2 = 2;
        System.out.println("Input: " + s2 + ", k = " + k2);
        System.out.println("Output: " + vf.maxVowels(s2, k2)); // Expected: 2

        // Test 3: No vowels
        String s3 = "bcdfg";
        int k3 = 3;
        System.out.println("Input: " + s3 + ", k = " + k3);
        System.out.println("Output: " + vf.maxVowels(s3, k3)); // Expected: 0

        // Test 4: k equals string length
        String s4 = "leetcode";
        int k4 = 8;
        System.out.println("Input: " + s4 + ", k = " + k4);
        System.out.println("Output: " + vf.maxVowels(s4, k4)); // Expected: 3

        // Test 5: Single character
        String s5 = "a";
        int k5 = 1;
        System.out.println("Input: " + s5 + ", k = " + k5);
        System.out.println("Output: " + vf.maxVowels(s5, k5)); // Expected: 1

        // Test 6: Edge case, k = 0
        String s6 = "abcde";
        int k6 = 0;
        System.out.println("Input: " + s6 + ", k = " + k6);
        System.out.println("Output: " + vf.maxVowels(s6, k6)); // Expected: 0
    }
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        for (int i = 0; i < k; i++) {
            if ("aeiou".contains(s.charAt(i) + "")) {
                currentVowels++;
            }
        }
        maxVowels = currentVowels;
        for (int i = k; i < s.length(); i++) {
            if ("aeiou".contains(s.charAt(i - k) + "")) {
                currentVowels--;
            }
            if ("aeiou".contains(s.charAt(i) + "")) {
                currentVowels++;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}
