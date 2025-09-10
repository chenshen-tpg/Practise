package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.EncodeAndDecodeString_271;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
            sb.append("\n");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String split[] = s.split("\n");
        List<String> li = new ArrayList<>();
        for (String temp : split){
            li.add(temp);
        }
        return li;
    }
}
