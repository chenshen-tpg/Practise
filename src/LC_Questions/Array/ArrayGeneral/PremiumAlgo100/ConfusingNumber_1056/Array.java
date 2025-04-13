package LC_Questions.Array.ArrayGeneral.PremiumAlgo100.ConfusingNumber_1056;

public class Array {
    public static void main(String[] args) {
        Array solution = new Array();
        solution.confusingNumber(916);
    }
    public boolean confusingNumber(int n) {
        String nums = n + "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length(); i++) {
            if ("23457".contains(nums.charAt(i) + "")) return false;
            else if (nums.charAt(i) == '0' || nums.charAt(i) == '1' || nums.charAt(i) == '8') sb.append(nums.charAt(i));
            else if (nums.charAt(i) == '6') sb.append('9');
            else if (nums.charAt(i) == '9') sb.append('6');
        }
        return !nums.equals(sb.reverse().toString());
    }
}
