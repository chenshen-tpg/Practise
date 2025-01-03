package LC_Questions.WholePackage.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubStringWithConcatenationOfAllWords_30_Hard_V2 {
    public static void main(String[] args) {
        SubStringWithConcatenationOfAllWords_30_Hard_V2 sc = new SubStringWithConcatenationOfAllWords_30_Hard_V2();
        String s = "barfoofoobarthefoobarman";
        String[] words = new String[]{"bar","foo","the"};
        List<Integer> res = sc.findSubstring(s, words);
        for (int i : res) {
            System.out.println(i);
        }
    }


    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        int n = s.length();
        int k = words.length;
        int wordLength = words[0].length();
        int substringSize = wordLength * k;

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) {
            HashMap<String, Integer> wordsFound = new HashMap<>();
            int wordsUsed = 0;
            boolean excessWord = false;
            for (int left = i, right = i; right <= n - wordLength; right += wordLength) {
                String sub = s.substring(right, right + wordLength);
                if (!wordCount.containsKey(sub)) {
                    wordsFound.clear();
                    wordsUsed = 0;
                    excessWord = false;
                    left = right + wordLength;
                } else {
                    while (right - left == substringSize || excessWord) {
                        String leftmostWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        wordsFound.put(leftmostWord, wordsFound.get(leftmostWord) - 1);
                        if (wordsFound.get(leftmostWord) >= wordCount.get(leftmostWord)) {
                            excessWord = false;
                        } else {
                            wordsUsed--;
                        }
                    }
                    wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
                    if (wordsFound.get(sub) <= wordCount.get(sub)) {
                        wordsUsed++;
                    } else {
                        excessWord = true;
                    }
                    if (wordsUsed == k && !excessWord) {
                        answer.add(left);
                    }
                }
            }
        }
        return answer;
    }
}
