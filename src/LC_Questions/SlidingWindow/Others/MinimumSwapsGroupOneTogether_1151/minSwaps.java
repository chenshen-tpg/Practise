package LC_Questions.SlidingWindow.Others.MinimumSwapsGroupOneTogether_1151;

public class minSwaps {
    public static void main(String[] args) {

    }
    public int minSwaps(int[] data) {
        int count = 0, one = 0, max = 0;
        for (int num:data) if (num == 1) count++;
        if (count <= 1) return 0;
        for (int i = 0; i < count; i++) if (data[i] == 1) one++;
        max = one;
        for (int i = count; i < data.length; i++) {
            if (data[i] == 1) one++;
            if (data[i - count] == 1) one--;
            max = Math.max(max, one);
        }
        return count - max;
    }
}
