package CodingQuestions.Algorithms.Array.SlidingWindow.AlternatingGroupsII_3208;

public class OnePass {
    public static void main(String[] args) {

    }
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int result = 0;
        int count = 1;
        int lastColor = colors[0];
        for (int i = 1; i < colors.length + k - 1; i++) {
            int index = i % colors.length;
            if (colors[index] == lastColor) {
                count = 1;
                lastColor = colors[index];
                continue;
            }
            count += 1;
            if (count >= k) result++;
            lastColor = colors[index];
        }
        return result;
    }
}
