package LC_Questions.LC_75.ArrayString;

public class ReverseVowelsInaString_345_easy {
    public static void main(String[] args) {
        ReverseVowelsInaString_345_easy rv = new ReverseVowelsInaString_345_easy();
        System.out.println(rv.reverseVowels("hello"));
    }
    boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
                || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }
    void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }
    public String reverseVowels(String s) {
        if (s == null || s.length()==0) {
            return s;
        }
        char[] sChar = s.toCharArray();
        int i = 0, j = s.length()-1;
        while(i<j){
            while (i < j && !isVowel(sChar[i])) {
                i++;
            }

            while (i < j && !isVowel(sChar[j])) {
                j--;
            }
            swap(sChar,i,j);
            i++;
            j--;
        }
        return new String(sChar);
    }
}
