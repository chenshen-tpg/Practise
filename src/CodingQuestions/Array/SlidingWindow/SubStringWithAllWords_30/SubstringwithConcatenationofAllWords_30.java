package CodingQuestions.Array.SlidingWindow.SubStringWithAllWords_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords_30 {
    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords_30 sc = new SubstringwithConcatenationofAllWords_30();
        String s = "barfoofoobarthefoobarman";
        String[] words = new String[]{"bar","foo","the"};
        List<Integer> res = sc.findSubstringMy_Version(s, words);
        for (int i : res) {
            System.out.println(i);
        }
    }
    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    private int wordLength;
    private int substringSize;
    private int k;

    private boolean check(int i, String s) {
        HashMap<String, Integer> remaining = new HashMap<>(wordCount);
        int wordsUsed = 0;
        for (int j = i; j < i + substringSize; j += wordLength) {
            String sub = s.substring(j, j + wordLength);
            if (remaining.getOrDefault(sub, 0) != 0) {
                remaining.put(sub, remaining.get(sub) - 1);
                wordsUsed++;
            } else {
                break;
            }
        }
        return wordsUsed == k;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;
        for (String word : words) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (check(i, s)) {
                answer.add(i);
            }
        }
        return answer;
    }

    public List<Integer> findSubstringMy_Version(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int substringSize = wordLength * words.length;
        for (int i = 0; i <= s.length() - substringSize; i++) {
            HashMap<String, Integer> temp = new HashMap<>(hm);
            int j = i;
            while (j < i + substringSize) {
                String sub = s.substring(j, j + wordLength);
                if (temp.containsKey(sub) && temp.get(sub) > 0) {
                    temp.put(sub, temp.get(sub) - 1);
                    j += wordLength;
                } else {
                    break;
                }
                if (j == i + substringSize) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }
    class Solution {
        private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        private int n;
        private int wordLength;
        private int substringSize;
        private int k;

        private void slidingWindow(int left, String s, List<Integer> answer) {
            HashMap<String, Integer> wordsFound = new HashMap<>();
            int wordsUsed = 0;
            boolean excessWord = false;

            // Do the same iteration pattern as the previous approach - iterate
            // word_length at a time, and at each iteration we focus on one word
            for (int right = left; right <= n - wordLength; right += wordLength) {
                String sub = s.substring(right, right + wordLength);
                if (!wordCount.containsKey(sub)) {
                    // Mismatched word - reset the window
                    wordsFound.clear();
                    wordsUsed = 0;
                    excessWord = false;
                    left = right + wordLength;
                } else {
                    // If we reached max window size or have an excess word
                    while (right - left == substringSize || excessWord) {
                        String leftmostWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        wordsFound.put(
                                leftmostWord,
                                wordsFound.get(leftmostWord) - 1
                        );

                        if (
                                wordsFound.get(leftmostWord) >=
                                        wordCount.get(leftmostWord)
                        ) {
                            // This word was an excess word
                            excessWord = false;
                        } else {
                            // Otherwise we actually needed it
                            wordsUsed--;
                        }
                    }

                    // Keep track of how many times this word occurs in the window
                    wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
                    if (wordsFound.get(sub) <= wordCount.get(sub)) {
                        wordsUsed++;
                    } else {
                        // Found too many instances already
                        excessWord = true;
                    }

                    if (wordsUsed == k && !excessWord) {
                        // Found a valid substring
                        answer.add(left);
                    }
                }
            }
        }

        public List<Integer> findSubstring(String s, String[] words) {
            n = s.length();
            k = words.length;
            wordLength = words[0].length();
            substringSize = wordLength * k;

            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < wordLength; i++) {
                slidingWindow(i, s, answer);
            }

            return answer;
        }
    }
}
