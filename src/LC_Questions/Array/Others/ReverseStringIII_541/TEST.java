package LC_Questions.Array.Others.ReverseStringIII_541;

public class TEST {
    public static void main(String[] args) {

    }

    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i += 2 * k) {
            if (i + k - 1 < str.length) reverse(i, i + k - 1, str);
            else reverse(i, str.length - 1, str);
        }
        return new String(str);
    }
    public void reverse(int i, int j, char[] str) {
        while (i < j) {
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
    }
}
