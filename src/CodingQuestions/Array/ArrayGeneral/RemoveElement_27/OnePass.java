package CodingQuestions.Array.ArrayGeneral.RemoveElement_27;

public class OnePass {
    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        int p = 0;
        for (int i = 0; i < nums.length;i++){
            if(nums[i] != val){
                nums[p++] = nums[i];
            }else{
                count--;
            }
        }
        return count;
    }
}
