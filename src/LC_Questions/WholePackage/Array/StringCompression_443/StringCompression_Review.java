package LC_Questions.WholePackage.Array.StringCompression_443;

public class StringCompression_Review {
    public static void main(String[] args) {
        StringCompression_Review sc = new StringCompression_Review();
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        char[] chars = new char[]{'a'};
        System.out.println(sc.review(chars));
    }
    public int review (char [] chars) {
        if (chars.length == 0) return 1;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = 1;
            while (index + i < chars.length && chars[i] == chars[i + index]) {
                index++;
            }
            chars[ans++] = chars[i];
            if (index > 1) {
                for (char ch : String.valueOf(index).toCharArray())
                    chars[ans++] = ch;
            }
            i += index - 1;
        }
        return chars.length;
    }
}
