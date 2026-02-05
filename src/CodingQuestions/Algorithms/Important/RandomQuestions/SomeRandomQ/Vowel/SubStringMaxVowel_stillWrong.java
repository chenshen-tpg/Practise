package CodingQuestions.Algorithms.Important.RandomQuestions.SomeRandomQ.Vowel;


/***
 * Given a string s and an integer k, find the maximum number of vowels
 * present in any substring of s that has a length k. Write a function to return the highest
 * count of vowel letters you can find in such a substring.
 * Implement the method maxVowels(String s, int k) to return max number of vowels.
 */
public class SubStringMaxVowel_stillWrong {

    public static void main(String[] args) {
        String test = "Aeikkfsdfdsiouiou";
        SubStringMaxVowel_stillWrong sotlution = new SubStringMaxVowel_stillWrong();
        sotlution.maxVowels(test, test.length());
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            int index = i;
            int cur = 0;
            while (index < k && "aeriou".contains(Character.toLowerCase(s.charAt(index)) + "")) {
                index++;
                cur++;
            }
//            String temp = s.substring(i, index);
            i = index;
            if (cur > max) {
                max = cur;
//                System.out.println(temp);
            }
        }
        return max;
    }

}
