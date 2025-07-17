package CodingQuestions.Math.PremiumAlgo100.ArmstrongNumber_1134;

public class Count {
    public static void main(String[] args) {
        Count solution = new Count();
        solution.isArmstrong(2);
    }

    public boolean isArmstrong(int n) {
        int count = 0, temp = n;
        while (temp > 0) {
            count += Math.pow(temp % 10, String.valueOf(n).length());
            temp /= 10;
        }
        return n == count;
    }
}
