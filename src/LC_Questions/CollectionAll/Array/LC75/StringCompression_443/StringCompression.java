package LC_Questions.CollectionAll.Array.LC75.StringCompression_443;

import java.util.HashMap;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
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
