package CodingQuestions.Math.CheckifNumberisaSumofPowersofThree_1780;

public class bruteForce {
    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(92));
    }
    public static boolean checkPowersOfThree(int n) {
        int power = 0;
        while (Math.pow(3, power) <= n) {
            power++;
        }
        while (n > 0) {
            if (n >= Math.pow(3, power)) {
                n -= (int) Math.pow(3, power);
            }
            if (n >= Math.pow(3, power)){
                return false;
            }
            power--;
        }
        return true;
    }
}
