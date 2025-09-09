package CodingQuestions.Algorithms.Array.SlidingWindow.MaximumNumberOfVowelsInASubStringOfGivenLength_1456;

public class CalculateFirstK_TheRestAfter {

    public static void main(String[] args) {
        String s = "a";
        int k = 1;
        System.out.println(helper(s, k));
    }

    public static int helper (String s,int k) {
        int ans = 0, count = 0;
        for (int i = 0; i < k; i++) {
            if ("aeiou".contains(s.charAt(i)+"")) count++;
        }
        //don't forget this, it won't go to the next loop when its length is 1
        ans = count;
        for (int i = k; i < s.length(); i++) {
            if ("aeiou".contains(s.charAt(i) + "")) {
                count++;
            }
            if ("aeiou".contains(s.charAt(i - k) + "")){
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
