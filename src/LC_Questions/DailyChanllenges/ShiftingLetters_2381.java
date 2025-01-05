package LC_Questions.DailyChanllenges;

public class ShiftingLetters_2381 {
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};  // 0,1,2
        ShiftingLetters_2381 obj = new ShiftingLetters_2381();
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
    public String shiftingLetters_Model_Ans(String s, int[][] shifts) {
        char[] ch = s.toCharArray();
        int[] count = new int[s.length()+1];

        for(int[] shift : shifts){
            int value = shift[2] == 1 ? 1 : -1;
            count[shift[0]] += value;
            count[shift[1] + 1] -= value;
        }

        int sum = 0;
        for(int i = 0; i < count.length - 1; i++){
            sum += count[i];
            int newChar = ((ch[i] - 'a') + sum) % 26;
            if(newChar < 0) newChar+= 26;
            ch[i] =  (char)('a' + newChar);
        }

        return String.valueOf(ch);
    }
}
