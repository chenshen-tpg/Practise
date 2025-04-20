package LC_Questions.Array.BinarySearch.PremiumAlgo100.MissingNumInArithmetric_1228;

public class Math {
    public int missingNumber(int[] arr) {
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
        int ini = arr[0];
        for (Integer a : arr) {
            if (a != ini) return ini;
            ini += diff;
        }
        return ini;
    }
}
