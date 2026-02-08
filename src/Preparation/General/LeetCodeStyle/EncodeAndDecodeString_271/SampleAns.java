package Preparation.General.LeetCodeStyle.EncodeAndDecodeString_271;

import java.util.Arrays;
import java.util.List;

public class SampleAns {
    public static void main(String[] args) {

    }
    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder("");
        for(String s : strs) {
            if (s.length() > 0) {
                str.append(s);
            } else {
                str.append("\t");
            }
            str.append("\n");
        }
        return str.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String split[] = s.split("\n");
        for(int i = 0; i < split.length; i++) {
            if(split[i].equals("\t")) split[i] = "";
        }
        return Arrays.asList(split);
    }
}
