package LC_Questions.Array.LC75.StringCompression_443;

public class NotSure {
    public static void main(String[] args) {

    }
    public static int test (char[] chars) {
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int c = 1;
            while (c + i < chars.length && chars[i] == chars[i + c]) {
                c++;
            }
            chars[ans++] = chars[i];
            if (c > 1) {
                for (char ch : String.valueOf(c).toCharArray()) {
                    chars[ans++] = ch;
                }
            }
            i += c - 1;
        }
        return ans;
    }
}
