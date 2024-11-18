package LC_Questions.LC_75.ArrayString;

public class StringCompression_443_med_review {
    public static void main(String[] args) {
        StringCompression_443_med_review sc = new StringCompression_443_med_review();
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(sc.compress(chars));
    }

    public int compress(char[] chars) {
        int l = 0;
        int r = chars.length;
        int res = 0;
        while (l < r) {
            int count = 1;
            while (l + count < r && chars[l + count] == chars[l]) {
                count++;
            }
            chars[res++] = chars[l];
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
            l += count;
        }
        return res;
    }

}
