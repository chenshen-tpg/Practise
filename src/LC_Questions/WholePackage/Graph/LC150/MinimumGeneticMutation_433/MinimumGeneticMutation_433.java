package LC_Questions.WholePackage.Graph.LC150.MinimumGeneticMutation_433;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation_433 {
    public static void main(String[] args) {
        MinimumGeneticMutation_433 mgm = new MinimumGeneticMutation_433();
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(mgm.minMutation(start, end, bank));
    }
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.add(start);
        seen.add(start);
        int s = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.remove();
                if (node.equals(end)) {
                    return s;
                }
                for (char c:new char[] {'A', 'C', 'G', 'T' })
                    for (int j = 0; j < node.length(); j++) {
                        String neighbor = node.substring(0, j) + c + node.substring(j + 1);
                        if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            q.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
            }
            s++;
        }
        return -1;
    }
    int minMutation=Integer.MAX_VALUE;

    public int minMutation1(String start, String end, String[] bank) {
        if(bank.length==0) return -1;
        helper(start, end, bank,0, new HashSet<>());
        return minMutation == Integer.MAX_VALUE?-1 : minMutation;
    }
    private void helper(String start, String end, String[] bank, int count,Set set){
        if(start.equals(end)) {
            minMutation = Math.min(minMutation, count);
            return;
        }
        for(int i=0;i<bank.length;i++){
            if(diff(start, bank[i]) == 1 && !set.contains(bank[i])) {
                set.add(bank[i]);
                helper(bank[i], end,bank, count+1, set);
                set.remove(bank[i]);
            }
        }
    }
    private int diff(String a,String b) {
        int count=0;
        for(int i = 0; i < 8; i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }
}
