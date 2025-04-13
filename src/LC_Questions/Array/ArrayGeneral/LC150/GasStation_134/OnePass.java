package LC_Questions.Array.ArrayGeneral.LC150.GasStation_134;

public class OnePass {
    public static void main(String[] args) {
        int [] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        linear(gas,cost);
    }
    public static int linear (int [] gas, int [] cost) {
        int total = 0, cur = 0, ans = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0) {
                ans = i + 1;
                cur = 0;
            }
        }
        if (total >= 0) {
            return ans;
        } else {
            return -1;
        }
    }
}
