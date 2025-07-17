package CodingQuestions.Hash.Others.High_AccessEmployees_2933;

import java.util.*;

public class HashMapSolution {
    public static void main(String[] args) {
        List<List<String>> access_times = new ArrayList<>(Arrays.asList(
                Arrays.asList("d", "0002"),
                Arrays.asList("c", "0808"),
                Arrays.asList("c", "0829"),
                Arrays.asList("e", "0215"),
                Arrays.asList("d", "1508"),
                Arrays.asList("d", "1444"),
                Arrays.asList("d", "1410"),
                Arrays.asList("c", "0809")
        ));
        System.out.println(highAccessEmployees(access_times));
    }

    private static List<String> highAccessEmployees(List<List<String>> accessTimes) {
        List<String> ans = new ArrayList<>();
        HashMap<String, List<Integer>> hm = new HashMap<>();
        for (List<String> access : accessTimes) {
            String employee = access.get(0);
            int time = Integer.parseInt(access.get(1));
            List<Integer> tempAL = hm.getOrDefault(employee, new ArrayList<>());
            tempAL.add(time);
            Collections.sort(tempAL);
            hm.put(employee, tempAL);
        }
        for (String s : hm.keySet()) {
            List<Integer> tempLi = hm.get(s);
            if (tempLi.size() <= 2) {
                continue;
            }
            for (int i = 2; i < tempLi.size(); i++) {
                if (tempLi.get(i) - tempLi.get(i - 2) < 100) {
                    ans.add(s);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
