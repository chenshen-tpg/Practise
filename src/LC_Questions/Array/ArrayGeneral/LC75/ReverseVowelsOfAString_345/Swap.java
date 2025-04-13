package LC_Questions.Array.ArrayGeneral.LC75.ReverseVowelsOfAString_345;

public class Swap {
    public static void main(String[] args) {
        Swap rv = new Swap();
        System.out.println(rv.reverseVowels("IceCreAm"));
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
        while(i < j){
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
