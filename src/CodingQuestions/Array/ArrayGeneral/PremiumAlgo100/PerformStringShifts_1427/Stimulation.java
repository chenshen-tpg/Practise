package CodingQuestions.Array.ArrayGeneral.PremiumAlgo100.PerformStringShifts_1427;

public class Stimulation {
    public static void main(String[] args) {

    }
    public String stringShift(String str, int [][] memo) {
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
