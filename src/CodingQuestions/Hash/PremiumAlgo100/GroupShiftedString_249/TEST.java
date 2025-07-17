package CodingQuestions.Hash.PremiumAlgo100.GroupShiftedString_249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TEST {
    public static void main(String[] args) {
        String [] strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
        TEST solution = new TEST();
        solution.groupStrings(strings);
    }
    public String getHash(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            //shifting sequence
            sb.append((char) ((chars[i] - chars[i - 1] + 26) % 26 + 'a'));
        }
        return sb.toString();
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String str : strings ) {
            hm.computeIfAbsent( getHash(str),k-> new ArrayList<>()).add(str);
        }
        List<List<String>> groups = new ArrayList<>();
        for (List<String> group : hm.values()) {
            groups.add(group);
        }
        return groups;
    }
}
