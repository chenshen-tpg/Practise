package Preparation.Specific.TikTok.Programming.PermutationsII_47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SampleAns2 {
    void permutationsGenerator(int[] nums,List<Integer> visitedIndexes,List<List<Integer>> result){
        if (visitedIndexes.size() == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int idx : visitedIndexes) {
                permutation.add(nums[idx]);
            }
            result.add(permutation);
        }
        Set<Integer> addedNumbers=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!visitedIndexes.contains(i) && !addedNumbers.contains(nums[i])){
                visitedIndexes.add(i);
                permutationsGenerator(nums,visitedIndexes,result);
                addedNumbers.add(nums[i]);
                visitedIndexes.remove(visitedIndexes.size() - 1);
            }
        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> visitedIndexes=new ArrayList<>();
        permutationsGenerator(nums,visitedIndexes,result);
        return result;
    }
}
