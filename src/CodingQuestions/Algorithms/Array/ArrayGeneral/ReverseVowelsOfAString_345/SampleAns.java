package CodingQuestions.Algorithms.Array.ArrayGeneral.ReverseVowelsOfAString_345;

public class SampleAns {
    public static void main(String[] args) {

    }

    public String reverseVowels(String s) {
        boolean vowel[] = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowel[c] = true;
        }
        char ch[] = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while (i < j) {
            while (i < j && !vowel[ch[i]]) {
                i++;
            }
            while (i < j && !vowel[ch[j]]) {
                j--;
            }
            if (i < j) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
            }
            i++;
            j--;

        }
        return new String(ch);

    }
}
