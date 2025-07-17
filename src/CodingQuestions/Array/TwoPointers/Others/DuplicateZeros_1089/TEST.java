package CodingQuestions.Array.TwoPointers.Others.DuplicateZeros_1089;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.duplicateZeros(new int [] {1,0,2,3,0,4,5,0});
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int j;
                for (j = arr.length - 2; j >= i + 1; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = 0;
                i++;
            }
        }
    }
}
