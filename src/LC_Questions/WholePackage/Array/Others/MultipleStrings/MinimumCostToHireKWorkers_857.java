package LC_Questions.WholePackage.Array.Others.MultipleStrings;

public class MinimumCostToHireKWorkers_857 {
    public static int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int total;
        while (true) {
            int temp = 0;
            for (int i = 0; i < piles.length; i++) {
                temp +=  Math.ceil((double)piles[i] / s);
            }
            total = temp;
            if (total <= h) {
                break;
            }else {
                s++;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        int [] test = {3,6,7,11};int h = 8;
        System.out.println(minEatingSpeed(test,h));
    }
}
