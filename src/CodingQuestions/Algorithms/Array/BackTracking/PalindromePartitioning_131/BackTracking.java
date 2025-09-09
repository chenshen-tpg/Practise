package CodingQuestions.Algorithms.Array.BackTracking.PalindromePartitioning_131;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {
    List<List<String>> li = new ArrayList<>();
    public static void main(String[] args) {
        BackTracking solution = new BackTracking();
        System.out.println(solution.partition("aab"));
    }
    public List<List<String>> partition(String s) {
        partition(0, s, new ArrayList<>());
        return li;
    }

    private void partition(int i, String s, ArrayList al) {
        if (i == s.length()) {
            li.add(new ArrayList<>(al));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (palindrome(sub)) {
                al.add(sub);
                partition(j + 1, s, al);
                al.remove(al.size() - 1);
            }
        }
    }
    public boolean palindrome (String s) {
        if (s.length() == 1) return true;
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
