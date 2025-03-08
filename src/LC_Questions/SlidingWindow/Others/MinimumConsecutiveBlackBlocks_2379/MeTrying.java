package LC_Questions.SlidingWindow.Others.MinimumConsecutiveBlackBlocks_2379;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying solution = new MeTrying();
        System.out.println(solution.helper("WBWBBBW",2));
    }

    public int helper(String blocks, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if ('W' == blocks.charAt(i)) count++;
        }
        int min = count;
        int index = 0;
        for (int i = k; i < blocks.length(); i++) {
            if ('W' == blocks.charAt(i)) count++;
            if ('W' == blocks.charAt(index)) count--;
            index++;
            min = Math.min(min, count);
        }
        return min;
    }
}
