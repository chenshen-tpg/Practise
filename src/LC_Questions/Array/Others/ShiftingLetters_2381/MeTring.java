package LC_Questions.Array.Others.ShiftingLetters_2381;

public class MeTring {
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};  // 0,1,2
        MeTring obj = new MeTring();
        String result = obj.shiftingLetters(s, shifts);
        System.out.println(result);
//        System.out.println(Character.valueOf((char) (Integer.valueOf(s.charAt(1)) + 1)));

    }
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder();
        int len = shifts.length;
        int [] cal = new int[s.length()];
        for (int i = 0; i < len; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];
            if (direction == 1) {
                for (int j = start; j <= end; j++) {
                    cal[j]++;
                }
            } else {
               for (int j = start; j <= end; j++) {
                   cal[j] --;
               }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int shift = (s.charAt(i) - 'a' + cal[i]) % 26;
            if (shift < 0) {
                shift += 26;
            }
            sb.append((char) (shift + 'a'));
        }
        return sb.toString();
    }

}
