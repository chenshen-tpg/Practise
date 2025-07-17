package CodingQuestions.Array.ArrayGeneral.Others.SortColors_75;

public class Dividend {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        sort(nums, 0, nums.length - 1);
    }
    public void sort(int [] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }
    public int partition (int [] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    public void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
