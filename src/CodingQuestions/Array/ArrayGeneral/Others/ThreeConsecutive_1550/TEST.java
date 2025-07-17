package CodingQuestions.Array.ArrayGeneral.Others.ThreeConsecutive_1550;

public class TEST {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        boolean flag = false;
        for (int a : arr) {
            if (a % 2 != 0) {
                count++;
                if (count == 3) {
                    flag = true;
                }
            }
            else {
                count = 0;
            }
        }
        return flag;
    }
}
