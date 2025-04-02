package LC_Questions.Array.Others.ReplaceElementsWithGreatestElements;

public class PrefixTrying {
    public static void main(String[] args) {
        helper(new int [] {17,18,5,4,6,1});
    }

    public static int helper (int [] arr) {
        if (arr.length == 1) return -1;
        int [] pre = new int [arr.length];
        for (int i = arr.length - 2; i > 0; i--) {
            pre[i] = Math.max(arr[i], pre[i + 1]);
        }
        return 0;
    }
}
