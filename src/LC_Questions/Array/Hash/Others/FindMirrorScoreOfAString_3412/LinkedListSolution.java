package LC_Questions.Array.Hash.Others.FindMirrorScoreOfAString_3412;

import java.util.LinkedList;

public class LinkedListSolution {

    public static void main(String[] args) {
        System.out.println(linkedListSolution("aczzx"));
    }

    public static long linkedListSolution(String s) {
        long res = 0;
        LinkedList<Integer>[] seen = new LinkedList[26];

        for (int i = 0; i < 26; ++i) {
            seen[i] = new LinkedList<>();
        }

        for (int i = 0; i < s.length(); ++i) {
            int a = s.charAt(i) - 'a';
            if (seen[25 - a].isEmpty()) seen[a].add(i);
            else {
                int j = seen[25 - a].pollLast();
                res += i - j;
            }
        }
        return res;
    }
}
