package CodingQuestions.Array.ArrayGeneral.ShiftingLetters_2381;

public class ItertaionAndChar {

    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};  // 0,1,2
        ItertaionAndChar solution = new ItertaionAndChar();
        String result = solution.IterationChar(s, shifts);
        System.out.println(result);
//        System.out.println(Character.valueOf((char) (Integer.valueOf(s.charAt(1)) + 1)));

    }
    public String IterationChar (String s, int[][] shifts) {
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
