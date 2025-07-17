package CodingQuestions.TipsAndSummary.BinarySearch;

public class BinarySearchModel {
/***
    The General Way of Thinking:
    Define Your Goal: What exactly are you trying to find in the sorted array? (e.g., exact match, first/last occurrence, lower/upper bound).
    Establish the Search Condition: Write the if condition that checks if nums[mid] satisfies your goal.
    Adjust Pointers Based on the Condition:
    If the condition is met: You've found a potential answer. Decide if you need to continue searching for a more specific answer (like the very first or very last). Adjust start or end accordingly.
    If nums[mid] is too small: Move start to mid + 1 to search the right half.
    If nums[mid] is too large: Move end to mid - 1 to search the left half.
    Initialize and Return resultIndex: Initialize resultIndex to a value indicating "not found" (like -1 or nums.length in some cases) and update it whenever you find a potential answer. Return the final resultIndex.

 */
//1. Finding an Exact Target:
    public void findExactTarget(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int resultIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                resultIndex = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
//2. Finding the First Occurrence of a Target
    public void FindingFirstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int resultIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                resultIndex = mid;
                end = mid - 1; // Keep searching left
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else { // nums[mid] > target
                end = mid - 1;
            }
        }
    }
//3. Finding the Last Occurrence of a Target:
    public void FindingLastOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int resultIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                resultIndex = mid;
                start = mid + 1; // Keep searching right
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else { // nums[mid] > target
                end = mid - 1;
            }
        }
    }

//4. Finding the Lower Bound (First element >= target):
    public void FindingLowerBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int resultIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                resultIndex = mid;
                end = mid - 1; // Try to find an even smaller index that satisfies the condition
            } else { // nums[mid] < target
                start = mid + 1;
            }
        }
    }
//5.   Finding the Upper Bound (First element > target):
    public void FindingUpperBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int resultIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                resultIndex = mid;
                end = mid - 1; // Try to find an even smaller index that satisfies the condition
            } else { // nums[mid] <= target
                start = mid + 1;
            }
        }
    }

}
