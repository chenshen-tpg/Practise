package LC_Questions.WholePackage.Array;

public class StringCompression_443_med_review {
    public static void main(String[] args) {
        StringCompression_443_med_review sc = new StringCompression_443_med_review();
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        System.out.println(sc.compress(chars));
        System.out.println(sc.test(chars));
    }
    // for loop might need to - 1 to avoid out of bound
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
    public static int test (char[] chars) {
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int c = 1;
            while (c + i < chars.length && chars[i] == chars[i + c]) {
                c++;
            }
            chars[ans++] = chars[i];
            if (c > 1) {
                for (char ch : Integer.toString(c).toCharArray()) {
                    chars[ans++] = ch;
                }
            }
            i += c - 1;
        }
        return ans;
    }



}
