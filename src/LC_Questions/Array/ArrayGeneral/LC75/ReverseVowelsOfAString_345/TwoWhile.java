package LC_Questions.Array.ArrayGeneral.LC75.ReverseVowelsOfAString_345;

public class TwoWhile {
    public static void main(String[] args) {

    }
    public static String method (String s) {
        int left = 0, right = s.length() - 1;
        char [] res = s.toCharArray();
        while (left < right) {
            while (left < right && !"aeiou".contains(Character.toLowerCase(s.charAt(left))+"")) {
                left++;
            }
            while (left < right && !"aeiou".contains(Character.toLowerCase(s.charAt(right))+"")) {
                right--;
            }
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            left++;
            right--;
        }
        return new String(res);
    }
}
