package CodingQuestions.Algorithms.OOP.DesignSpreadSheet_3484;

public class TEST {
    int[][] memo;

    public static void main(String[] args) {
        TEST spreadsheet = new TEST(458);

        spreadsheet.setCell("A1", 10);                         // Set A1=10
        System.out.println(spreadsheet.getValue("=A1+6"));     // Output: 16
        spreadsheet.setCell("B2", 15);                         // Set B2=15
        System.out.println(spreadsheet.getValue("=A1+B2"));    // Output: 25
        spreadsheet.resetCell("A1");                           // Reset A1
        System.out.println(spreadsheet.getValue("=A1+B2"));    // Output: 15
    }
    public TEST(int rows) {
        memo = new int[26][rows + 1];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        memo[col][row] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) ;
        memo[col][row] = 0;
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        int mid = 0;
        for (int i = 0; i < formula.length(); i++) {
            if ('+' == formula.charAt(i)) {
                String s1 = formula.substring(0, i);
                String s2 = formula.substring(i + 1);
                int left = Character.isUpperCase(s1.charAt(0))
                        ? memo[s1.charAt(0) - 'A'][Integer.parseInt(s1.substring(1))]
                        : Integer.parseInt(s1);
                int right = Character.isUpperCase(s2.charAt(0))
                        ? memo[s2.charAt(0) - 'A'][Integer.parseInt(s2.substring(1))]
                        : Integer.parseInt(s2);
                return left + right;
            }
        }
        return -1;
    }
}
