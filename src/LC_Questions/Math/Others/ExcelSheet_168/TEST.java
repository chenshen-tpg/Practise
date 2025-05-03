package LC_Questions.Math.Others.ExcelSheet_168;

public class TEST {
    public static void main(String[] args) {
        convertToTitle(701);
    }
    public static String convertToTitle(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            num --;
            sb.append(Character.toChars(num % 26 +'A'));
            num /= 26;
        }
        return sb.reverse().toString();
    }
}
