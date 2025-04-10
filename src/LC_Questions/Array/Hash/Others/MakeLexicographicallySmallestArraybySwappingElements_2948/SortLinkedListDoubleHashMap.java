package LC_Questions.Array.Hash.Others.MakeLexicographicallySmallestArraybySwappingElements_2948;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class SortLinkedListDoubleHashMap {
    public static void main(String[] args) {
        SortLinkedListDoubleHashMap s = new SortLinkedListDoubleHashMap();
        int [] nums = {1,7,6,18,2,1};
        int limit = 2;
        s.lexicographicallySmallestArray(nums,limit);
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) numsSorted[i] = nums[i];
        Arrays.sort(numsSorted);
        //nums 1,7,6,18,2,1;
        //sortedNums 1,1,2,6,7,18;
        int currGroup = 0;
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);
        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(currGroup, new LinkedList<>(Arrays.asList(numsSorted[0])));
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) currGroup++;
            numToGroup.put(numsSorted[i], currGroup);
            if (!groupToList.containsKey(currGroup)) groupToList.put(currGroup, new LinkedList<Integer>());
            groupToList.get(currGroup).add(numsSorted[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }
        return nums;
    }
}
