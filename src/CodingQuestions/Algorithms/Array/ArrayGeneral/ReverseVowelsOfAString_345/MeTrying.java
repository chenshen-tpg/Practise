package CodingQuestions.Algorithms.Array.ArrayGeneral.ReverseVowelsOfAString_345;

public class MeTrying {
    public static void main(String[] args) {
        StringBuilder sb  = new StringBuilder("asd");
        sb.reverse();
        System.out.println(sb.charAt(1));
    }
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ("aeiouAEIOU".contains(s.charAt(i) + "")) {
                temp.append(s.charAt(i));
            }
        }
        int index = 0;
        temp = temp.reverse();
        for (int i = 0; i < s.length(); i++) {
            if ("aeiouAEIOU".contains(s.charAt(i) + "")) {
                sb.append(temp.charAt(index++));
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
