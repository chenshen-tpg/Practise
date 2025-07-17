package CodingQuestions.Array.Prefix.Others.CountTheHiddenSequences_2145;

public class TEST {
    public static void main(String[] args) {

    }
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int index = lower;
        while (index <= upper) {
            int len = differences.length, j = 0;
            for (int i = 0; i < differences.length; i++) {
                if((differences[i] + index >= lower) && differences[i] + index <= upper) {
                    j++;
                }
            }
            if (j == len) index++;
        }
        return index;
    }
}
