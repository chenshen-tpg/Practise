package LC_Questions.Array.Others.FindUniqueBinaryString_1980;

public class NotSureWhyItWorks {
    public static void main(String[] args) {
        String [] nums = {"01", "10"};
    }
    public String helper (String [] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }

        return sb.toString();
    }
}
