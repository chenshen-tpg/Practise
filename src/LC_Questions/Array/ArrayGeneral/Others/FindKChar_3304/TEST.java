package LC_Questions.Array.ArrayGeneral.Others.FindKChar_3304;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.kthCharacter(5);
    }

    public char kthCharacter(int k) {
        String word = "a";
        return helper(word, k);
    }

    public static char helper(String word, int k) {
        if (word.length() >= k) {
            return word.charAt(k - 1);
        }
        int index = 0;
        StringBuilder str = new StringBuilder(word);
        while (index < word.length()) {
            char ch = word.charAt(index);
            str.append((char) (ch + 1));
            index++;
        }
        return helper(str.toString(), k);

    }
}
