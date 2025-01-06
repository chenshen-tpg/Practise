package LC_Questions.ContestQ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class FindMirrorScoreOfAString_3412_Q2 {
    public static void main(String[] args) {
        String s = "zadavyayobbgqsexaabk";

        System.out.println(findMirrorScoreSS(s));
    }

    public long calculateScore(String s) {
        long score = 0;
        int [] markForward = new int [26];
        int [] markBackWard = new int [26];
        for (int i = 0; i < s.length(); i++) {
            markForward[s.charAt(i) - 'a'] += 1 ;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            markBackWard[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (markForward[i] == 1 && markBackWard[j] == 1) {
                    markForward[i] = 0;
                    markBackWard[j] = 0;
                    score += i - j;
                }
            }
        }
        return score;
    }
    public static long findMirrorScore(String s) {
        long score = 0;
        int [] marked = new int[s.length()];
        Arrays.fill(marked, 0);
        for (int i = 0; i < s.length(); i++) {
            if (marked[i] == 1) continue;
            char mirror = (char) ('z' - (s.charAt(i) - 'a'));
            for (int j = i - 1; j >= 0; j--) {
                if (marked[j] == 0 && s.charAt(j) == mirror) {
                    marked[i] = 1;
                    marked[j] = 1;
                    score += i - j;
                    break;
                }
            }
        }
        return score;
    }

    public static long findMirrorScoreS(String s) {
        long score = 0;
        boolean[] marked = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (marked[i]) continue;
            char mirrorChar = (char) ('z' - (s.charAt(i) - 'a'));
            for (int j = i - 1; j >= 0; j--) {
                if (!marked[j] && s.charAt(j) == mirrorChar) {
                    marked[i] = true;
                    marked[j] = true;
                    score += i - j;
                    break;
                }
            }
        }

        return score;
    }
    public static long calculateScoreHashMap(String s) {
        long score = 0;
        int [] marked = new int[s.length()];
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (marked[i] == 1) continue;
            char mirror = (char) ('z' - (s.charAt(i) - 'a'));
            if (lastSeen.containsKey(mirror) && marked[lastSeen.get(mirror)] == 0) {
                int j = lastSeen.get(mirror);
                marked[i] = 1;
                marked[j] = 1;
                score += i - j;
            }
            lastSeen.put(s.charAt(i), i);
        }
        return score;
    }
    public static long findMirrorScoreSS(String s) {
            long score = 0;
            int[] marked = new int[s.length()];
            Arrays.fill(marked, 0);
            Map<Character, Integer> lastSeen = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (marked[i] == 1) continue;
                char current = s.charAt(i);
                char mirror = (char) ('z' - (current - 'a'));
                if (lastSeen.containsKey(mirror)) {
                    int j = lastSeen.get(mirror);
                    if (marked[j] == 0) {
                        marked[i] = 1;
                        marked[j] = 1;
                        score += i - j;
                        lastSeen.remove(mirror);
                        continue;
                    }
                }
                lastSeen.put(current, i);
            }
            return score;
    }
    public long calculateScore_LinkedList(String s) {
        LinkedList<Integer>[] seen = new LinkedList[26];
        for (int i = 0; i < 26; ++i) {
            seen[i] = new LinkedList<>();
        }
        long res = 0;
        for (int i = 0; i < s.length(); ++i) {
            int a = s.charAt(i) - 'a';
            if (seen[25 - a].isEmpty()) {
                seen[a].add(i);
            } else {
                int j = seen[25 - a].pollLast();
                res += i - j;
            }
        }
        return res;
    }
    public long calculateScore_HashMap(String s) {
        int n = s.length();
        long score = 0;

        Map<Integer, Stack<Integer>> map=new HashMap<>();
        for(int i=0; i<26; i++){
            map.put(i, new Stack<>());
        }

        for(int i=0; i<n; i++){
            int chIdx=s.charAt(i)-'a';
            int mrIdx=25-chIdx;  //Mirror Character INT

            if(!map.get(mrIdx).isEmpty()){
                score+=i-map.get(mrIdx).pop();
            }
            else{
                map.get(chIdx).push(i);
            }
        }

        return score;
    }
}
