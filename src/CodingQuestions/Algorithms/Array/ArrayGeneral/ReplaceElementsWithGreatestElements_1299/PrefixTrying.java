package CodingQuestions.Algorithms.Array.ArrayGeneral.ReplaceElementsWithGreatestElements_1299;

public class PrefixTrying {
    public static void main(String[] args) {
        helper(new int [] {17,18,5,4,6,1});
    }

    public static int[] helper (int [] arr) {
        int keeper = -1;
        for (int i = arr.length -1; i >= 0; i-- ) {
            int temp = arr[i];
            arr[i] = keeper;
            keeper = Math.max(temp, keeper);
        }
        return arr;
    }
}
