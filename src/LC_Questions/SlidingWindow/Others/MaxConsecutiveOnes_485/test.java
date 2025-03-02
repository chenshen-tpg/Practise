package LC_Questions.SlidingWindow.Others.MaxConsecutiveOnes_485;

public class test {
    public static void main(String[] args) {
        count(new int [] {1, 1, 0, 1, 1, 1});
    }
    public static int count (int [] arr) {
        int ans = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 0;
            }
        }
        return ans;
    }
}
