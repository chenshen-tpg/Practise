package LC_Questions.Array.ArrayGeneral.LC150.GasStation_134;

public class GasStation_134 {
    public static void main(String[] args) {
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};
        GasStation_134 gs = new GasStation_134();
        System.out.println(gs.canCompleteCircuit(gas,cost));
    }

        public int canCompleteCircuit(int[] gas, int[] cost) {
            int currGain = 0, totalGain = 0, answer = 0;
            for (int i = 0; i < gas.length; ++i) {
                totalGain += gas[i] - cost[i];
                currGain += gas[i] - cost[i];
                if (currGain < 0) {
                    answer = i + 1;
                    currGain = 0;
                }
            }
            return totalGain >= 0 ? answer : -1;
        }

}
