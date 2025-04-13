package LC_Questions.Array.ArrayGeneral.LC75.IncreasingTripletSubsequence_334;

public class Review {
    public static void main(String[] args) {

    }
    public boolean helper (int [] arr ){
        int [] nums = {1,2,3,4,5};
        int first = 0;
        int second = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            }
            else if (nums[i] <= second) {
                second = nums[i];
            }
            else {
                return true;
            }
        }
        return false;
    }
}
