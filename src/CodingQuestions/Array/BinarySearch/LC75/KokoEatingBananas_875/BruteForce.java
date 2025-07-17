package CodingQuestions.Array.BinarySearch.LC75.KokoEatingBananas_875;

public class BruteForce {
    public static void main(String[] args) {
        BruteForce solution = new BruteForce();
        int [] piles = {3,6,7,11};
        int h = 8;
        System.out.println(solution.helper1(piles, h));
    }

    public int helper1(int [] piles, int h) {
        int speed = 1;
        while (true) {
            int hourSpent = 0;
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / speed);
                if (hourSpent > h) {
                    break;
                }
            }
            if (hourSpent <= h) {
                return speed;
            } else {
                speed += 1;
            }
        }
    }

}
