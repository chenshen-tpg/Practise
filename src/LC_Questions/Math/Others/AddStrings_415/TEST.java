package LC_Questions.Math.Others.AddStrings_415;

public class TEST {
    public static void main(String[] args) {
        addStrings("1","9");
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int l2 = num2.length() - 1, l1 = num1.length() - 1;
        int t1 = 0, t2 = 0, bit = 0;
        while (l1 >= 0 || l2 >= 0) {
            if (l1 >= 0) t1 = Integer.valueOf(num1.charAt(l1)+"");
            else t1 = 0;
            if (l2 >= 0) t2 = Integer.valueOf(num2.charAt(l2)+"");
            else t2 = 0;
            int temp = t1 + t2;
            if (l1 == 0 && l2 == 0) {
                res.append(temp);
                return res.toString();
            }
            res.append((temp + bit) % 10);
            if (temp > 10) bit = 1;
            else bit = 0;
            l1--;
            l2--;
        }
        return res.reverse().toString();
    }
}
