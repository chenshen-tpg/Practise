package Preparation.General.RandomQuestions;

public class TEST {
    public static void main(String[] args) {
        TEST solutioon = new TEST();
        solutioon.vowelConsonantScore("axeyizou");
    }
    public int vowelConsonantScore(String s) {
        int c = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("aeiou".contains(s.charAt(i) + "")) {
                sum++;
            } else if (Character.isLetter(s.charAt(i))){
                c++;
            }
        }
        if (c == 0) return 0;
        return Math.floorDiv(sum, c);
    }
}
