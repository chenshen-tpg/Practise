package CodingQuestions.Array.ArrayGeneral.MajorityElement_169;

public class HMsolution {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        java.util.HashMap<Integer, Integer> hm = new java.util.HashMap<>();
        if (nums.length <= 2) {
            return nums[0];
        }
        for (Integer num:nums) {
            hm.put(num, hm.getOrDefault(num,0) + 1);
            if (hm.containsKey(num) && hm.get(num) > nums.length / 2){
                return num;
            }
        }
        return 0;
    }

}
