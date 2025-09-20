package CodingQuestions.Algorithms.OOP.DesignSpreadSheet_3484;

import java.util.HashMap;

public class SampleAns {
    public static void main(String[] args) {

    }
    HashMap<String, Integer> mpp = new HashMap<>();
    public SampleAns(int rows) {}
    public void setCell(String cell, int value) {
        mpp.put(cell, value);
    }
    public void resetCell(String cell) {
        mpp.put(cell, 0);
    }
    public int getValue(String formula) {
        formula = formula.substring(1);
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '+') {
                String s1 = formula.substring(0, i), s2 = formula.substring(i + 1);
                int left = Character.isUpperCase(s1.charAt(0)) ? mpp.getOrDefault(s1, 0) : Integer.parseInt(s1);
                int right = Character.isUpperCase(s2.charAt(0)) ? mpp.getOrDefault(s2, 0) : Integer.parseInt(s2);
                return left + right;
            }
        }
        return 0;
    }
}
