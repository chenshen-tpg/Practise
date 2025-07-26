package CodingQuestions.Array.ArrayGeneral.LC75.StringCompression_443;

public class SampleAns {
    public static void main(String[] args) {
        SampleAns sc = new SampleAns();
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(sc.compress(chars));
    }


    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < chars.length; i++) {
            Integer count = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            sb.append(chars[i]);
            if (count > 1) {
                sb.append(count);
            }
        }
        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
