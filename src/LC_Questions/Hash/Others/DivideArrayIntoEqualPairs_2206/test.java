package LC_Questions.Hash.Others.DivideArrayIntoEqualPairs_2206;

public class test {
    public static void main(String[] args) {

    }
    public boolean divideArray(int[] nums) {
        int n = 0;
        for (Integer num : nums) {
            if (num > n) n = num;
        }
        int [] mem = new int [n + 1];
        for (Integer num : nums) {
            mem[num]++;
        }
        for (Integer me : mem) {
            if (me % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
