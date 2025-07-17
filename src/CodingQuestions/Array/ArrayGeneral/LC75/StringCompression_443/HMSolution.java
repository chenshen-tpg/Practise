package CodingQuestions.Array.ArrayGeneral.LC75.StringCompression_443;

import java.util.HashMap;

public class HMSolution {
    public static void main(String[] args) {

    }
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
}
