package LC_Questions.LC_General.Arrays;

import java.util.PriorityQueue;

public class ReorganizeString_767 {
    public static void main(String[] args) {
        ReorganizeString();
    }
    public static String method1(){
            String s = "aab";
            var charCounts = new int[26];
            for (char c : s.toCharArray()) {
                charCounts[c - 'a']++;
            }
            var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
            for (int i = 0; i < 26; i++) {
                if (charCounts[i] > 0) {
                    pq.offer(new int[] {i + 'a', charCounts[i]});
                }
            }
            var sb = new StringBuilder();
            while (!pq.isEmpty()) {
                var first = pq.poll();
                if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                    sb.append((char) first[0]);
                    if (--first[1] > 0) {
                        pq.offer(first);
                    }
                } else {
                    if (pq.isEmpty()) {
                        return "";
                    }
                    var second = pq.poll();
                    sb.append((char) second[0]);
                    if (--second[1] > 0) {
                        pq.offer(second);
                    }

                    pq.offer(first);
                }
            }

            return sb.toString();
    }
    public static void ReorganizeString() {
        String S = "aab";
        int N = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
        }
        int max = 0;
        int letter = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                letter = i;
            }
        }
        if (max > (N + 1) / 2) {
            System.out.println("");
        }
        char[] ans = new char[N];
        int t = 0;
        while (count[letter] > 0) {
            ans[t] = (char) (letter + 'a');
            t += 2;
            count[letter]--;
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (t >= N) {
                    t = 1;
                }
                ans[t] = (char) (i + 'a');
                t += 2;
                count[i]--;
            }
        }
        System.out.println(new String(ans));
    }
}
