package CodingQuestions.Array.TwoPointers.Others.MovePiecesToObtainString_2337;

public class Missing_Order {
    public static void main(String[] args) {
        Missing_Order solution = new Missing_Order();
        solution.canChange("_L__R__R_", "L______RR");
    }
    public boolean canChange(String start, String target) {
        int countleft = 0, countright = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') countleft++;
            if (start.charAt(i) == 'R') countright++;
        }
        StringBuilder sb = new StringBuilder();
        int temp = target.length() - (countleft + countright) - 1;
        while(countleft-- > 0) sb.append("L");
        while(temp-- > 0) sb.append("_");
        while(countright-- > 0) sb.append("R");

        return target.equals(sb.toString());
    }
}
