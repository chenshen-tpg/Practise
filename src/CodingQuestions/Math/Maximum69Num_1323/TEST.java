package CodingQuestions.Math.Maximum69Num_1323;

public class TEST {
    public static void main(String[] args) {

    }
//    In Java, when you iterate over an array using for (char digit : digits),
//    digit is a copy of the array element, not a reference to the element itself.
    public int maximum69Number (int num) {
        char[] digits = String.valueOf(num).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(digits));
    }
}
