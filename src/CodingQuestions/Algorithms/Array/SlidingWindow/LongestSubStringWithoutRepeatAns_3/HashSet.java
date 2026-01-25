package CodingQuestions.Algorithms.Array.SlidingWindow.LongestSubStringWithoutRepeatAns_3;

public class HashSet {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        java.util.HashSet<Character> hs = new java.util.HashSet();
        int start = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            while (hs.contains(c)) {
                hs.remove(s.charAt(start++));
            }
            hs.add(c);
            ans = Math.max(ans, hs.size());
        }
        return ans;
    }

}
