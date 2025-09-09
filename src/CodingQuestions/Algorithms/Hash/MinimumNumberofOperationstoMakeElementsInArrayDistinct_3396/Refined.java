package CodingQuestions.Algorithms.Hash.MinimumNumberofOperationstoMakeElementsInArrayDistinct_3396;

public class Refined {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 2, 3, 3, 5, 7};
        System.out.println(method(nums1));
    }

    public static int method(int [] nums) {
        int[] freq = new int[101];
        for(int i = nums.length-1; i >= 0; --i){
            if (++freq[nums[i]] > 1) {
                return i / 3 + 1;
            }
        }
        return 0;
    }
}

