package CodingQuestions.Hash.PremiumAlgo100.GroupShiftedString_249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RuleOfOneToMany {

    public static void main(String[] args) {

    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList();
        HashMap<Integer,List<String>> hm = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            hm.computeIfAbsent(strings[i].length(), k -> new ArrayList<>()).add(strings[i]);
        }
        for (List<String> stringList : hm.values()) {
            res.add(stringList);
        }
        return res;
    }
}
