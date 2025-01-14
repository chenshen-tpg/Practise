package LC_Questions.WholePackage.Array.LC75.StringCompression_443;

import java.util.HashMap;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        char[] chars = new char[]{'a'};
        System.out.println(sc.compress(chars));
    }
    //"a","2","b","2","c","3"

    public static int HashMapForTheResult (char[] s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for (char ss:s){
            hm.put(ss, hm.getOrDefault(ss, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char ss:hm.keySet()) {
            if (hm.get(ss) > 1) {
                sb.append(ss);
                sb.append(hm.get(ss));
            } else {
                sb.append(ss);
            }
        }
        return sb.length();
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
