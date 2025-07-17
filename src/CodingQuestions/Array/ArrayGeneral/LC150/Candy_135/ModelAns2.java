package CodingQuestions.Array.ArrayGeneral.LC150.Candy_135;

public class ModelAns2 {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 1, i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum++;
                i++;
                continue;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }
            int downpeak = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += downpeak;
                downpeak++;
                i++;
            }
            if (downpeak > peak) {
                sum += downpeak - peak;
            }
        }
        return sum;
    }
}
