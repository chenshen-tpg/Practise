package LC_Questions.Array.ArrayGeneral.Others.ThirdMaximumNumber_414;

import java.util.TreeSet;

public class TreeSetSolution {
    public static void main(String[] args) {

    }
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums){
            set.add(num);
            if(set.size() > 3){
                set.pollFirst();
            }
        }
        return (set.size() == 3) ? set.pollFirst() : set.pollLast();
    }
}
