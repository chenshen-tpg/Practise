package CodingQuestions.Array.TwoPointers.MaxNumberOfKSumPairs_1679;

public class hashmapSolution {
    public static void main(String[] args) {
        hashmapSolution mn = new hashmapSolution();
        System.out.println(mn.maxOperations_hashmap(new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4}, 2));
    }

    public int maxOperations_hashmap(int[] nums, int k) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = k - nums[i];
            if (map.getOrDefault(current, 0) > 0 & map.getOrDefault(complement, 0) > 0) {
                if ((current == complement) && map.get(current) < 2) continue;
                map.put(current, map.get(current) - 1);
                map.put(complement, map.get(complement) - 1);
                count++;
            }
        }
        return count;
    }
}
