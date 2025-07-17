package CodingQuestions.Array.BinarySearch.LC150.SearchInsertPositions_35;

public class SearchInsertPosition_35_ez {
    public static void main(String[] args) {
        SearchInsertPosition_35_ez s = new SearchInsertPosition_35_ez();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(s.searchInsert(nums, target));
    }
    public int searchInsert(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot =  left + (right - left) / 2;
            if (nums[pivot] == target){
                return pivot;
            }
            if (target < nums[pivot]) {
                right = pivot - 1;
            }
            else {
                left = pivot + 1;
            }
        }
        return left;
    }
}
