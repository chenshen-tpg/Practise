package CodingQuestions.Algorithms.Array.TwoPointers.DuplicateZeros_1089;

public class Another {
    public void duplicateZeros(int[] arr) {
        int zero = 0;
        int len = arr.length - 1;

        for (int i = 0; i <= len - zero; i++) {
            if (arr[i] == 0) {
                if (i == len - zero) {
                    arr[len] = 0;
                    len -= 1;
                    break;
                }
                zero++;
            }
        }
        int last = len - zero;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + zero] = 0;
                zero--;
                arr[i + zero] = 0;
            } else {
                arr[i + zero] = arr[i];
            }
        }
    }
}
