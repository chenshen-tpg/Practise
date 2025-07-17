package CodingQuestions.Array.ArrayGeneral.Others.FindUniqueBinaryString_1980;

import java.util.HashSet;
import java.util.Set;

public class IntEquivelant {
    public static void main(String[] args) {
        String [] s = {"111","011","001"};
        findDifferentBinaryString(s);
    }
    public static String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet();
        for (String num : nums) integers.add(Integer.parseInt(num, 2));
        for (int num = 0; num <= nums.length; num++) {
            if (!integers.contains(num)) {
                String ans = Integer.toBinaryString(num);
                while (ans.length() < nums.length) {
                    ans = "0" + ans;
                }
                return ans;
            }
        }
        return "";
    }
}
