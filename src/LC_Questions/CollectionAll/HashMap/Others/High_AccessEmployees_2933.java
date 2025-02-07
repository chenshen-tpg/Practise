package LC_Questions.CollectionAll.HashMap.Others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class High_AccessEmployees_2933 {
    public static void main(String[] args) {
        List<List<String>> access_times = new ArrayList<>();
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
