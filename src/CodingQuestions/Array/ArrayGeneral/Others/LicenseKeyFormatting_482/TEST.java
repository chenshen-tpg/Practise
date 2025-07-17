package CodingQuestions.Array.ArrayGeneral.Others.LicenseKeyFormatting_482;

public class TEST {
    public static void main(String[] args) {

    }
    public String licenseKeyFormatting(String s, int k) {
        int count = k;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-' && count > 0) {
                sb.append(Character.toUpperCase(s.charAt(i)));
                count--;
            }
            if (count == 0) {
                count = k;
                sb.append('-');
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
