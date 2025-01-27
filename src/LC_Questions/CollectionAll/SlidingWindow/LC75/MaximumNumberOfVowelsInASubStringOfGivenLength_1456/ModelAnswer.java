package LC_Questions.CollectionAll.SlidingWindow.LC75.MaximumNumberOfVowelsInASubStringOfGivenLength_1456;

public class ModelAnswer {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowelsSlidingWin(s, k));
    }
    public static int maxVowels(String s, int k) {
        String vowel = "aeiou";
        int ans = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {
            int temp = 0;
            int index = 0;
            while (index < k) {
                if (vowel.contains(s.charAt(i + index) + "")) {
                    temp++;
                }
                index++;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
    public static int maxVowelsSlidingWin(String s, int k) {
        String vowel = "aeiou";
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (vowel.contains(s.charAt(i) + "")) ans++;
        }
        int count = ans;
        for (int i = k; i < s.length(); i++) {
            count += vowel.contains(s.charAt(i) + "") ? 1 : 0;
            count -= vowel.contains(s.charAt(i-k) + "") ? 1: 0;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
