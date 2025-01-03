package LC_Questions.WholePackage.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankTeamsByVotes_1366 {
    public static void main(String[] args) {
        RankTeamsByVotes_1366 ranker = new RankTeamsByVotes_1366();

        String[] votes1 = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println(ranker.rankTeams(votes1)); // Expected output: "ACB"

        String[] votes2 = {"WXYZ", "XYZW"};
        System.out.println(ranker.rankTeams(votes2)); // Expected output: "XWYZ"

        String[] votes3 = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        System.out.println(ranker.rankTeams(votes3)); // Expected output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"

        String[] votes4 = {"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};
        System.out.println(ranker.rankTeams(votes4)); // Expected output: "ABC"
    }
    public String rankTeams_int(String[] votes) {
        int len = votes[0].length();
        int[][] map = new int[26][len + 1];
        for(int i = 0; i < 26; i++) map[i][len] = i;

        for(int i = 0; i < votes.length; i++){
            String s = votes[i];
            for(int j = 0; j < len; j++){
                map[s.charAt(j) - 'A'][j]++;
            }
        }
        Arrays.sort(map, (a, b) ->{
            for(int i = 0; i < len; i++){
                if(a[i] < b[i]) return 1;
                if(a[i] > b[i]) return -1;
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append((char)('A' + map[i][len]));
        }
        return sb.toString();
    }

    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int l = votes[0].length();
        for(String vote : votes){
            for(int i = 0; i < l; i++){
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[l]);
                map.get(c)[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for(int i = 0; i < l; i++){
                if(map.get(a)[i] != map.get(b)[i]){
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        return sb.toString();
    }
}
