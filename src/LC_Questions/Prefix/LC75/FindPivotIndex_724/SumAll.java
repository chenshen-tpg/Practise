package LC_Questions.Prefix.LC75.FindPivotIndex_724;

public class SumAll {
    public static void main(String[] args) {
        SumAll solution = new SumAll();
        System.out.println(solution.sum(new int[]{1, 7, 3, 6, 5, 6}));

    }

    private int sum(int[] arr) {
        int left = 0, sum = 0;
        for (Integer a :arr) {
            sum += a;
        }
        //left plus one and right minus one
        for (int i = 0; i < arr.length; i++) {
            if (left == sum - left - arr[i]) return i;
            left += arr[i];
        }
        return -1;
    }
}
