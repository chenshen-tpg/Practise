package LC_Questions.SlidingWindow.Others.AlternatingGroupsII_3208;

public class test {
    public static void main(String[] args) {
        System.out.println(6 % 7);
    }
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        int n = colors.length;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j < i + n; j++) {
                if (colors[j % n] != colors[j - 1] && colors[j % n] != j + 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
