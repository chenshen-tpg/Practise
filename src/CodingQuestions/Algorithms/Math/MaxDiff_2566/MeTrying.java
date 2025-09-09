package CodingQuestions.Algorithms.Math.MaxDiff_2566;

public class MeTrying {
    public static void main(String[] args) {
        minMaxDifference(99293302);
    }
    public static int minMaxDifference(int num) {
        if (num < 10) return 9;
        String temp = String.valueOf(num);
        int index = 0;
        while (temp.charAt(index) == '9' && index < temp.length() - 1) {
            index ++;
        }
        int max = Integer.valueOf(temp.replaceAll(String.valueOf(temp.charAt(index)), "9"));
        int min = Integer.valueOf(temp.replaceAll(String.valueOf(temp.charAt(0)), "0"));
        return  max - min;
    }
}
