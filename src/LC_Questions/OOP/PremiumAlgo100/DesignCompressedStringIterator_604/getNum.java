package LC_Questions.OOP.PremiumAlgo100.DesignCompressedStringIterator_604;

public class getNum {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String s = "L10e2t1C1o1d1e1";
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            int num = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
//                core of the number extraction logic
                num = num * 10 + s.charAt(i) - '0';
                i++;
            }
            for (int j = 0; j < num; j++) sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}
