package LC_Questions.CollectionAll.Array.Others;

public class CoungSubarraysOfLengthThreeWithoutACondition_3392 {
    public static void main(String[] args) {
        int [] nums = {1,2,1,4,1};
        helper(nums);
    }

    public static int [] helper(int [] arr) {
        int [] ans = new int [3];
        for (int i = 0; i < arr.length - 2; i++) {
                if (2* (arr[i] + arr[i+2]) == arr[i+1]) {
                    ans = new int [] {arr[i], arr[i+1], i+2};
                }
            }
        return ans;
    }
}
