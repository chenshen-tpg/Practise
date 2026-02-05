package CodingQuestions.Algorithms.Important.RandomQuestions.SomeRandomQ.Vowel;

public class AIGenerated {
    public static void main(String[] args) {
        String test = "Aeikkfsdfdsiouiou";
        AIGenerated solution = new AIGenerated();
        System.out.println(solution.maxVowels(test, 7));
    }

    //Sliding window
    private int maxVowels(String s, int k) {
        int max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (i >= k && isVowel(s.charAt(i - k))) {
                count--;
            }
            if (i >= k - 1) {
                max = Math.max(max, count);
            }
        }
        return max;
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
