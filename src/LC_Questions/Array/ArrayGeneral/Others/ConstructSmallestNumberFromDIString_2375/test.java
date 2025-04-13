package LC_Questions.Array.ArrayGeneral.Others.ConstructSmallestNumberFromDIString_2375;

import java.util.HashSet;

public class test {
    HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) {
        test solution = new test();
        String pattern = "IIIDIDDD";
        solution.solver(pattern);
    }

    public  String solver (String s) {
        return helper(1, s);
    }

    public String helper(int base, String s) {
        if (base > 9 || base < 0 || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = base; i < s.length(); i++) {
            if (hs.contains(i)) {
                return helper(base + 1, s);
            } else {
                if (s.charAt(i) == 'I') {
                    base += 1;
                    sb.append(base + "");
                } else {
                    base -= 1;
                    sb.append(base + "");
                }
                hs.add(base);
            }
        }
        return sb.toString();
    }
}
