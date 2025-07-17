package CodingQuestions.Array.BitManipulation.Ohters.FindKthBitInN_1545;

public class Wrong {
    public char findKthBit(int n, int k) {
        int count = n;
        StringBuilder init = new StringBuilder("0");
        StringBuilder temp = new StringBuilder();
        while (count > 0) {
            init.append(temp);
            temp = new StringBuilder();
            temp.append(init);
            temp.append("1");
            temp.append(helper(init.toString()));
            count--;
        }
        return init.charAt(k);
    }


    public String helper (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ("0".equals(s.charAt(i))) sb.append("1");
            else sb.append("0");
        }
        return sb.reverse().toString();
    }
}
