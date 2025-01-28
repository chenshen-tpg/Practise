package LC_Questions.CollectionAll.Array.DailyChallenges;

import java.util.Arrays;

public class MinimumLengthofStringAfterOperations_3223 {



    public static void main(String[] args) {
        String s = "abaacbcbb";
        // a least three
        // delete left
        // delete right

        // bacbcbb
        // acbcb
//        System.out.println((char)('a' + 1));
        System.out.println(model_ans(s));
    }

    public static int model_ans (String s) {

        int[] charFrequency = new int[26];
        int totalLength = 0;
        for (char currentChar : s.toCharArray()) {
            charFrequency[currentChar - 'a']++;
        }
        for (int frequency : charFrequency) {
            if (frequency == 0) continue;
            if (frequency % 2 == 0) {
                totalLength += 2;
            } else {
                totalLength += 1;
            }
        }
        return totalLength;
    }
    public static int method_Wrong (String s) {
        int ans = 0;
        int [] smemo = new int [s.length()];
        Arrays.fill(smemo,1);
        if (s.length() < 3) return s.length();
        char [] memo = new char [26];
        for (char c : s.toCharArray()) {
            memo[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int count = 0;
            if (memo[i] > 2) {
                memo[i] -= 2;
                for (int j = 0; j < s.length(); j++) {
                    if (count == 3) break;
                    if (s.charAt(j) == (char)('a'+ i)) {
                        if (count != 1) {
                            smemo[j] = 0;
                        }
                    }
                    count++;
                }
            }
        }
        return s.length();
    }
}
