package CodingQuestions.Stack.MaximumScoreFromRemovingSubString_1717;

import java.util.Stack;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();

        // Test Case 1: Basic example
        String s1 = "ababa";
        int x1 = 5;
        int y1 = 3;
        System.out.println("Maximum Gain (Test Case 1): " + solution.maximumGain(s1, x1, y1)); // Expected: 16

        // Test Case 2: No pairs
        String s2 = "cccc";
        int x2 = 4;
        int y2 = 6;
        System.out.println("Maximum Gain (Test Case 2): " + solution.maximumGain(s2, x2, y2)); // Expected: 0

        // Test Case 3: Mixed pairs
        String s3 = "abbaab";
        int x3 = 7;
        int y3 = 5;
        System.out.println("Maximum Gain (Test Case 3): " + solution.maximumGain(s3, x3, y3)); // Expected: 24

        // Test Case 4: High priority pair dominates
        String s4 = "abababab";
        int x4 = 10;
        int y4 = 1;
        System.out.println("Maximum Gain (Test Case 4): " + solution.maximumGain(s4, x4, y4)); // Expected: 40

        // Test Case 5: Low priority pair dominates
        String s5 = "babababa";
        int x5 = 2;
        int y5 = 8;
        System.out.println("Maximum Gain (Test Case 5): " + solution.maximumGain(s5, x5, y5)); // Expected: 32
    }
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba" : "ab";
        String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount = (s.length() - stringAfterFirstPass.length()) / 2;
        totalScore += removedPairsCount * Math.max(x, y);
        String stringAfterSecondPass = removeSubstring(stringAfterFirstPass,lowPriorityPair);
        removedPairsCount = (stringAfterFirstPass.length() - stringAfterSecondPass.length()) /2;
        totalScore += removedPairsCount * Math.min(x, y);
        return totalScore;
    }
    private String removeSubstring(String input, String targetPair) {
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == targetPair.charAt(1) && !charStack.isEmpty() && charStack.peek() == targetPair.charAt(0)) {
                charStack.pop();
            } else {
                charStack.push(currentChar);
            }
        }
        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }
}
