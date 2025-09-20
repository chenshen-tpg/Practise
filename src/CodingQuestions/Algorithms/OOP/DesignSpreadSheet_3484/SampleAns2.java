package CodingQuestions.Algorithms.OOP.DesignSpreadSheet_3484;

public class SampleAns2 {
    int[][] memo;

    public static void main(String[] args) {
        SampleAns2 spreadsheet = new SampleAns2(862);
        spreadsheet.setCell("V846", 52719);
    }
    public SampleAns2(int rows) {
        memo = new int[26][rows];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        memo[col][row] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        memo[col][row] = 0;
    }

    public int getValue(String formula) {
        int plusIndex = formula.indexOf('+', 1);
        String s1 = formula.substring(1, plusIndex);
        String s2 = formula.substring(plusIndex + 1);
        return getTermValue(s1) + getTermValue(s2);
    }

    private int getTermValue(String term) {
        if (Character.isUpperCase(term.charAt(0))) {
            int col = term.charAt(0) - 'A';
            int row = Integer.parseInt(term.substring(1)) - 1;
            return memo[col][row];
        }
        return Integer.parseInt(term);
    }
}
