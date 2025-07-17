package CodingQuestions.Array.Prefix.Others.CountTheHiddenSequences_2145;

public class Count {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int cur = 0, max = 0, min = 0;
        for (Integer diff : differences) {
            cur += diff;
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            if (max - min > upper - lower) return 0;
        }
        return (upper - lower) - (max - min) + 1;
    }
}
