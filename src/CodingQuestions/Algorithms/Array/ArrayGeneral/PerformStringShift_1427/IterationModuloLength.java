package CodingQuestions.Algorithms.Array.ArrayGeneral.PerformStringShift_1427;

public class IterationModuloLength {
    public static void main(String[] args) {
        System.out.println(performStringShift("abcdefg", new int[][]{{0, 1}, {1, 2}})); // Output: "fgabcde"
        System.out.println(performStringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}})); // Output: "efgabcd"
        System.out.println(performStringShift("hhcjwpd", new int[][]{{0, 3}})); // Output: "defgabc"
        System.out.println(performStringShift("wpdhhcj", new int[][]{{0, 4}}));
    }

    public static String performStringShift(String str, int [][] memo) {
        int shift = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i][0] == 0) {
                shift += memo[i][1];
            } else {
                shift -= memo[i][1];
            }
        }
        shift %= str.length();
        StringBuilder sb = new StringBuilder();
        if (shift > 0) {
            sb.append(str.substring(shift) + str.substring(0, shift));
        } else if (shift < 0) {
            shift = Math.abs(shift);
            sb.append(str.substring(str.length() - shift) + str.substring(0, str.length() - shift));
        } else {
            return str;
        }
        return sb.toString();
    }
}
