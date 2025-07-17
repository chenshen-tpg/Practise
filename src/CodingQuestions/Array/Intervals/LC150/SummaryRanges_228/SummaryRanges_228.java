package CodingQuestions.Array.Intervals.LC150.SummaryRanges_228;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> li = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while(i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start != nums[i]) {
                li.add(start + "->" + nums[i]);
            } else {
                li.add(""+start);
            }
        }
        return li;
    }
}
