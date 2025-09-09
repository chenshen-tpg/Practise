package CodingQuestions.Algorithms.Hash.High_AccessEmployees_2933;

import java.util.*;

public class MeTrying {
    public static void main(String[] args) {
        List<List<String>> testCases = new ArrayList<>(Arrays.asList(
                Arrays.asList("d", "0002"),
                Arrays.asList("c", "0808"),
                Arrays.asList("c", "0829"),
                Arrays.asList("e", "0215"),
                Arrays.asList("d", "1508"),
                Arrays.asList("d", "1444"),
                Arrays.asList("d", "1410"),
                Arrays.asList("c", "0809")
        ));
        findTheEmployee(testCases);
    }

    public static List<String> findTheEmployee (List<List<String>> li) {
        List<String> ans = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for (int i = 0; i < li.size(); i++) {
            String e = li.get(i).get(0);
            String n = li.get(i).get(1);
            if (!hm.containsKey(e)) {
                hm.put(e, new ArrayList<>());
                hm.get(e).add(n);
            } else {
                hm.get(e).add(n);
            }
        }

        for (String s : hm.keySet()) {
            Collections.sort(hm.get(s));
            List<String> temp = hm.get(s);
            if (temp.size() <= 2) continue;
            // key is to just check two between all the list.
            for (int i = 2; i < temp.size(); i++) {
                if (Integer.valueOf(temp.get(i)) - Integer.valueOf(temp.get(i-2)) < 100) ans.add(s);
            }
        }
        return ans;
    }
}
